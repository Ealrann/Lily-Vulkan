package org.sheepy.vulkan.model.image;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.sheepy.vulkan.model.image.builder.ImageInfoBuilder;
import org.sheepy.vulkan.model.image.builder.ImageLayoutBuilder;
import org.sheepy.vulkan.model.image.builder.SamplerInfoBuilder;

public interface ImageModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<SamplerInfo> SAMPLER_INFO = new GroupBuilder<SamplerInfo>().name("SamplerInfo").concrete(true).addFeatures(SamplerInfo.Features.ALL).lmBuilder(new BuilderSupplier<>(SamplerInfoBuilder::new)).build();
    Group<ImageInfo> IMAGE_INFO = new GroupBuilder<ImageInfo>().name("ImageInfo").concrete(true).addFeatures(ImageInfo.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageInfoBuilder::new)).build();
    Group<ImageLayout> IMAGE_LAYOUT = new GroupBuilder<ImageLayout>().name("ImageLayout").concrete(true).addFeatures(ImageLayout.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageLayoutBuilder::new)).build();
    List<Group<?>> ALL = List.of(SAMPLER_INFO, IMAGE_INFO, IMAGE_LAYOUT);
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
