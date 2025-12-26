package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.CompositeImageBuilder;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;

public interface CompositeImage extends IVulkanImage, ImageInfo {
  static Builder builder() {
    return new CompositeImageBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ImageInlay> inlays();
  IVulkanImage background();
  void background(final IVulkanImage background);

  interface FeatureIDs {
    int FORMAT = ImageInfo.FeatureIDs.FORMAT;
    int USAGES = ImageInfo.FeatureIDs.USAGES;
    int TILING = ImageInfo.FeatureIDs.TILING;
    int MIP_LEVELS = ImageInfo.FeatureIDs.MIP_LEVELS;
    int INITIAL_LAYOUT = ImageInfo.FeatureIDs.INITIAL_LAYOUT;
    int NAME = Named.FeatureIDs.NAME;
    int INLAYS = -987945009;
    int BACKGROUND = 899518857;
  }

  interface Features<T extends Features<T>> extends IVulkanImage.Features<T>, ImageInfo.Features<T> {
    Attribute<EFormat, EFormat, Listener<EFormat>, ImageInfo.Features<?>> FORMAT = ImageInfo.Features.FORMAT;
    Attribute<EImageUsage, List<EImageUsage>, Listener<List<EImageUsage>>, ImageInfo.Features<?>> USAGES = ImageInfo.Features.USAGES;
    Attribute<Integer, Integer, IntListener, ImageInfo.Features<?>> TILING = ImageInfo.Features.TILING;
    Attribute<Integer, Integer, IntListener, ImageInfo.Features<?>> MIP_LEVELS = ImageInfo.Features.MIP_LEVELS;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, ImageInfo.Features<?>> INITIAL_LAYOUT = ImageInfo.Features.INITIAL_LAYOUT;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<ImageInlay, List<ImageInlay>, Listener<List<ImageInlay>>, Features<?>> INLAYS = new RelationBuilder<ImageInlay, List<ImageInlay>, Listener<List<ImageInlay>>, Features<?>>().name("inlays").many(true).contains(true).id(CompositeImage.FeatureIDs.INLAYS).concept(() -> VulkanResourceModelDefinition.Groups.IMAGE_INLAY).build();
    Relation<IVulkanImage, IVulkanImage, Listener<IVulkanImage>, Features<?>> BACKGROUND = new RelationBuilder<IVulkanImage, IVulkanImage, Listener<IVulkanImage>, Features<?>>().name("background").mandatory(true).id(CompositeImage.FeatureIDs.BACKGROUND).concept(() -> VulkanResourceModelDefinition.Groups.I_VULKAN_IMAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(FORMAT, USAGES, TILING, MIP_LEVELS, INITIAL_LAYOUT, NAME, INLAYS, BACKGROUND);
  }

  interface Builder extends IFeaturedObject.Builder<CompositeImage> {
    Builder format(EFormat format);
    Builder addUsage(EImageUsage usage);
    Builder tiling(int tiling);
    Builder mipLevels(int mipLevels);
    Builder initialLayout(EImageLayout initialLayout);
    Builder name(String name);
    Builder addInlay(Supplier<ImageInlay> inlay);
    Builder background(Supplier<IVulkanImage> background);
    Builder addInlays(List<ImageInlay> inlays);
    Builder addUsages(List<EImageUsage> usages);
  }
}
