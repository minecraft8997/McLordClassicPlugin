package ru.mclord.classic.plugin;

import ru.mclord.classic.Manager;
import ru.mclord.classic.McLordClassic;
import ru.mclord.classic.ShouldBeCalledBy;

import java.util.HashSet;
import java.util.Set;

public class CPEManager implements Manager {
    private static final CPEManager INSTANCE = new CPEManager();

    private final Set<CPE> supportedExtensions = new HashSet<>();

    private CPEManager() {
    }

    public static CPEManager getInstance() {
        return INSTANCE;
    }

    @ShouldBeCalledBy(thread = "main")
    public boolean isExtensionSupported(String name, int version) {
        // since equals() and hashCode() methods are
        // marked final, we can freely use this approach
        return supportedExtensions.contains(new CPE(name, version));
    }

    @ShouldBeCalledBy(thread = "main")
    public Set<CPE> getSupportedExtensions() {
        return new HashSet<>(supportedExtensions);
    }

    @ShouldBeCalledBy(thread = "main")
    /* package-private */ Set<CPE> getSupportedExtensionsFast() {
        return supportedExtensions;
    }

    @ShouldBeCalledBy(thread = "main")
    /* package-private */ void activateExtension(String name, int version) {
        for (CPE extension : supportedExtensions) {
            if (extension.name.equals(name) && extension.version == version) {
                extension.activate();

                break;
            }
        }
    }

    @ShouldBeCalledBy(thread = "main")
    public void registerExtension(CPE extension) {
        if (!checkStage()) {
            throw new IllegalStateException(
                    "Cannot register extensions during current game stage");
        }
        if (supportedExtensions.contains(extension)) {
            throw new IllegalArgumentException(
                    "Extension " + extension + " is already registered");
        }

        supportedExtensions.add(extension);
    }

    @Override
    public boolean checkStage() {
        return McLordClassic.game().getStage() == McLordClassic.GameStage.PRE_INITIALIZATION;
    }
}
