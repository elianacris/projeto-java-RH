package br.org.postalis.training.rh;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModulithTests {

    @Test
    void verifyModuleStructure() {
        ApplicationModules modules = ApplicationModules.of(RhSystemApplication.class);
        modules.verify();
    }

    @Test
    void generateDocumentation() {
        ApplicationModules modules = ApplicationModules.of(RhSystemApplication.class);
        new Documenter(modules)
            .writeDocumentation()
            .writeModuleCanvases();
    }
}
