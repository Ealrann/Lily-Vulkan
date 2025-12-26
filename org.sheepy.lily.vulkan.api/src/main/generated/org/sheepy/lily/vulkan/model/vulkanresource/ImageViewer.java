package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ImageViewerBuilder;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;

public interface ImageViewer extends IMemoryChunkPart, IVulkanImage, ImageInfo {
  static Builder builder() {
    return new ImageViewerBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ImageDataProvider dataProvider();
  boolean mipmapEnabled();
  void dataProvider(final ImageDataProvider dataProvider);
  void mipmapEnabled(final boolean mipmapEnabled);

  interface FeatureIDs {
    int FORMAT = ImageInfo.FeatureIDs.FORMAT;
    int USAGES = ImageInfo.FeatureIDs.USAGES;
    int TILING = ImageInfo.FeatureIDs.TILING;
    int MIP_LEVELS = ImageInfo.FeatureIDs.MIP_LEVELS;
    int INITIAL_LAYOUT = ImageInfo.FeatureIDs.INITIAL_LAYOUT;
    int NAME = Named.FeatureIDs.NAME;
    int DATA_PROVIDER = 360327155;
    int MIPMAP_ENABLED = -1497580959;
  }

  interface Features<T extends Features<T>> extends IMemoryChunkPart.Features<T>, IVulkanImage.Features<T>, ImageInfo.Features<T> {
    Attribute<EFormat, EFormat, Listener<EFormat>, ImageInfo.Features<?>> FORMAT = ImageInfo.Features.FORMAT;
    Attribute<EImageUsage, List<EImageUsage>, Listener<List<EImageUsage>>, ImageInfo.Features<?>> USAGES = ImageInfo.Features.USAGES;
    Attribute<Integer, Integer, IntListener, ImageInfo.Features<?>> TILING = ImageInfo.Features.TILING;
    Attribute<Integer, Integer, IntListener, ImageInfo.Features<?>> MIP_LEVELS = ImageInfo.Features.MIP_LEVELS;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, ImageInfo.Features<?>> INITIAL_LAYOUT = ImageInfo.Features.INITIAL_LAYOUT;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<ImageDataProvider, ImageDataProvider, Listener<ImageDataProvider>, Features<?>> DATA_PROVIDER = new RelationBuilder<ImageDataProvider, ImageDataProvider, Listener<ImageDataProvider>, Features<?>>().name("dataProvider").mandatory(true).contains(true).id(ImageViewer.FeatureIDs.DATA_PROVIDER).concept(() -> VulkanResourceModelDefinition.Groups.IMAGE_DATA_PROVIDER).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> MIPMAP_ENABLED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("mipmapEnabled").mandatory(true).defaultValue("false").id(ImageViewer.FeatureIDs.MIPMAP_ENABLED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(FORMAT, USAGES, TILING, MIP_LEVELS, INITIAL_LAYOUT, NAME, DATA_PROVIDER, MIPMAP_ENABLED);
  }

  interface Builder extends IFeaturedObject.Builder<ImageViewer> {
    Builder format(EFormat format);
    Builder addUsage(EImageUsage usage);
    Builder tiling(int tiling);
    Builder mipLevels(int mipLevels);
    Builder initialLayout(EImageLayout initialLayout);
    Builder name(String name);
    Builder dataProvider(Supplier<ImageDataProvider> dataProvider);
    Builder mipmapEnabled(boolean mipmapEnabled);
    Builder addUsages(List<EImageUsage> usages);
  }
}
