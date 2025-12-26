package org.sheepy.lily.openal.model.openal;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.openal.model.openal.builder.OpenALEngineBuilder;

public interface OpenALModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<OpenALEngine> OPENAL_ENGINE = new GroupBuilder<OpenALEngine>().name("OpenALEngine").concrete(true).addInclude(() -> new IncludeBuilder<IEngine>().group(() -> ApplicationModelDefinition.Groups.I_ENGINE).build()).addFeatures(OpenALEngine.Features.ALL).lmBuilder(new BuilderSupplier<>(OpenALEngineBuilder::new)).build();
    List<Group<?>> ALL = List.of(OPENAL_ENGINE);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    List<Enum<?>> ALL = List.of();
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    List<JavaWrapper<?>> ALL = List.of();
  }
}
