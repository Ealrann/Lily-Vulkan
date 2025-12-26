package org.sheepy.vulkan.model.barrier;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.vulkan.model.barrier.builder.ImageTransitionBuilder;

public interface BarrierModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<Barrier> BARRIER = new GroupBuilder<Barrier>().name("Barrier").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(Barrier.Features.ALL).build();
    Group<AbstractBufferBarrier> ABSTRACT_BUFFER_BARRIER = new GroupBuilder<AbstractBufferBarrier>().name("AbstractBufferBarrier").addInclude(() -> new IncludeBuilder<Barrier>().group(() -> BARRIER).build()).addFeatures(AbstractBufferBarrier.Features.ALL).build();
    Group<AbstractImageBarrier> ABSTRACT_IMAGE_BARRIER = new GroupBuilder<AbstractImageBarrier>().name("AbstractImageBarrier").addInclude(() -> new IncludeBuilder<Barrier>().group(() -> BARRIER).build()).addFeatures(AbstractImageBarrier.Features.ALL).build();
    Group<ImageTransition> IMAGE_TRANSITION = new GroupBuilder<ImageTransition>().name("ImageTransition").concrete(true).addFeatures(ImageTransition.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageTransitionBuilder::new)).build();
    List<Group<?>> ALL = List.of(BARRIER, ABSTRACT_BUFFER_BARRIER, ABSTRACT_IMAGE_BARRIER, IMAGE_TRANSITION);
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
