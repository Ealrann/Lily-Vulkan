package org.sheepy.vulkan.model.pipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.sheepy.vulkan.model.pipeline.builder.PushConstantRangeBuilder;
import org.sheepy.vulkan.model.pipeline.builder.SpecializationConstantBuilder;

public interface PipelineModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<PushConstantRange> PUSH_CONSTANT_RANGE = new GroupBuilder<PushConstantRange>().name("PushConstantRange").concrete(true).addFeatures(PushConstantRange.Features.ALL).lmBuilder(new BuilderSupplier<>(PushConstantRangeBuilder::new)).build();
    Group<SpecializationConstant> SPECIALIZATION_CONSTANT = new GroupBuilder<SpecializationConstant>().name("SpecializationConstant").concrete(true).addFeatures(SpecializationConstant.Features.ALL).lmBuilder(new BuilderSupplier<>(SpecializationConstantBuilder::new)).build();
    List<Group<?>> ALL = List.of(PUSH_CONSTANT_RANGE, SPECIALIZATION_CONSTANT);
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
