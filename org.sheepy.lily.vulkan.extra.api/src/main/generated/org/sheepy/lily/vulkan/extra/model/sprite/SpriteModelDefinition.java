package org.sheepy.lily.vulkan.extra.model.sprite;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.presentation.IPresentationPkg;
import org.sheepy.lily.core.model.presentation.PresentationModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntityResolver;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.sprite.builder.SpriteBuilder;
import org.sheepy.lily.vulkan.extra.model.sprite.builder.SpriteExtensionBuilder;
import org.sheepy.lily.vulkan.extra.model.sprite.builder.SpritePkgBuilder;
import org.sheepy.lily.vulkan.model.process.IPipelineExtension;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface SpriteModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<SpriteExtension> SPRITE_EXTENSION = new GroupBuilder<SpriteExtension>().name("SpriteExtension").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineExtension>().group(() -> ProcessModelDefinition.Groups.I_PIPELINE_EXTENSION).build()).addInclude(() -> new IncludeBuilder<IBufferDataSource>().group(() -> VulkanResourceModelDefinition.Groups.I_BUFFER_DATA_SOURCE).build()).addFeatures(SpriteExtension.Features.ALL).lmBuilder(new BuilderSupplier<>(SpriteExtensionBuilder::new)).build();
    Group<ISpriteDataSource> I_SPRITE_DATA_SOURCE = new GroupBuilder<ISpriteDataSource>().name("ISpriteDataSource").addInclude(() -> new IncludeBuilder<IBufferDataSource>().group(() -> VulkanResourceModelDefinition.Groups.I_BUFFER_DATA_SOURCE).build()).addFeatures(ISpriteDataSource.Features.ALL).build();
    Group<SpritePkg> SPRITE_PKG = new GroupBuilder<SpritePkg>().name("SpritePkg").concrete(true).addInclude(() -> new IncludeBuilder<ISpriteDataSource>().group(() -> I_SPRITE_DATA_SOURCE).build()).addInclude(() -> new IncludeBuilder<IEntityResolver>().group(() -> RenderingModelDefinition.Groups.I_ENTITY_RESOLVER).build()).addInclude(() -> new IncludeBuilder<IPresentationPkg>().group(() -> PresentationModelDefinition.Groups.I_PRESENTATION_PKG).build()).addFeatures(SpritePkg.Features.ALL).lmBuilder(new BuilderSupplier<>(SpritePkgBuilder::new)).build();
    Group<Sprite> SPRITE = new GroupBuilder<Sprite>().name("Sprite").concrete(true).addInclude(() -> new IncludeBuilder<Presentation>().group(() -> RenderingModelDefinition.Groups.PRESENTATION).build()).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(Sprite.Features.ALL).lmBuilder(new BuilderSupplier<>(SpriteBuilder::new)).build();
    List<Group<?>> ALL = List.of(SPRITE_EXTENSION, I_SPRITE_DATA_SOURCE, SPRITE_PKG, SPRITE);
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
