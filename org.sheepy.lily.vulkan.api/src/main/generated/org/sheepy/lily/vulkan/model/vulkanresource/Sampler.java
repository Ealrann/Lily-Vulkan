package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.SamplerBuilder;
import org.sheepy.vulkan.model.enumeration.EBorderColor;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.ESamplerAddressMode;
import org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode;
import org.sheepy.vulkan.model.image.SamplerInfo;

public interface Sampler extends SamplerInfo, IVulkanResource {
  static Builder builder() {
    return new SamplerBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  IVulkanImage image();
  void image(final IVulkanImage image);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int MIN_FILTER = SamplerInfo.FeatureIDs.MIN_FILTER;
    int MAG_FILTER = SamplerInfo.FeatureIDs.MAG_FILTER;
    int MIPMAP_MODE = SamplerInfo.FeatureIDs.MIPMAP_MODE;
    int ADDRESS_MODE = SamplerInfo.FeatureIDs.ADDRESS_MODE;
    int BORDER_COLOR = SamplerInfo.FeatureIDs.BORDER_COLOR;
    int ANISOTROPY_ENABLED = SamplerInfo.FeatureIDs.ANISOTROPY_ENABLED;
    int UNNORMALIZED_COORDINATES = SamplerInfo.FeatureIDs.UNNORMALIZED_COORDINATES;
    int COMPARE_ENABLE = SamplerInfo.FeatureIDs.COMPARE_ENABLE;
    int LOD_BIAS = SamplerInfo.FeatureIDs.LOD_BIAS;
    int MIN_LOD = SamplerInfo.FeatureIDs.MIN_LOD;
    int MAX_LOD = SamplerInfo.FeatureIDs.MAX_LOD;
    int MAX_ANISOTROPY = SamplerInfo.FeatureIDs.MAX_ANISOTROPY;
    int IMAGE = 457257758;
  }

  interface Features<T extends Features<T>> extends SamplerInfo.Features<T>, IVulkanResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EFilter, EFilter, Listener<EFilter>, SamplerInfo.Features<?>> MIN_FILTER = SamplerInfo.Features.MIN_FILTER;
    Attribute<EFilter, EFilter, Listener<EFilter>, SamplerInfo.Features<?>> MAG_FILTER = SamplerInfo.Features.MAG_FILTER;
    Attribute<ESamplerMipmapMode, ESamplerMipmapMode, Listener<ESamplerMipmapMode>, SamplerInfo.Features<?>> MIPMAP_MODE = SamplerInfo.Features.MIPMAP_MODE;
    Attribute<ESamplerAddressMode, ESamplerAddressMode, Listener<ESamplerAddressMode>, SamplerInfo.Features<?>> ADDRESS_MODE = SamplerInfo.Features.ADDRESS_MODE;
    Attribute<EBorderColor, EBorderColor, Listener<EBorderColor>, SamplerInfo.Features<?>> BORDER_COLOR = SamplerInfo.Features.BORDER_COLOR;
    Attribute<Boolean, Boolean, BooleanListener, SamplerInfo.Features<?>> ANISOTROPY_ENABLED = SamplerInfo.Features.ANISOTROPY_ENABLED;
    Attribute<Boolean, Boolean, BooleanListener, SamplerInfo.Features<?>> UNNORMALIZED_COORDINATES = SamplerInfo.Features.UNNORMALIZED_COORDINATES;
    Attribute<Boolean, Boolean, BooleanListener, SamplerInfo.Features<?>> COMPARE_ENABLE = SamplerInfo.Features.COMPARE_ENABLE;
    Attribute<Float, Float, FloatListener, SamplerInfo.Features<?>> LOD_BIAS = SamplerInfo.Features.LOD_BIAS;
    Attribute<Integer, Integer, IntListener, SamplerInfo.Features<?>> MIN_LOD = SamplerInfo.Features.MIN_LOD;
    Attribute<Integer, Integer, IntListener, SamplerInfo.Features<?>> MAX_LOD = SamplerInfo.Features.MAX_LOD;
    Attribute<Float, Float, FloatListener, SamplerInfo.Features<?>> MAX_ANISOTROPY = SamplerInfo.Features.MAX_ANISOTROPY;
    Relation<IVulkanImage, IVulkanImage, Listener<IVulkanImage>, Features<?>> IMAGE = new RelationBuilder<IVulkanImage, IVulkanImage, Listener<IVulkanImage>, Features<?>>().name("image").id(Sampler.FeatureIDs.IMAGE).concept(() -> VulkanResourceModelDefinition.Groups.I_VULKAN_IMAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, MIN_FILTER, MAG_FILTER, MIPMAP_MODE, ADDRESS_MODE, BORDER_COLOR, ANISOTROPY_ENABLED, UNNORMALIZED_COORDINATES, COMPARE_ENABLE, LOD_BIAS, MIN_LOD, MAX_LOD, MAX_ANISOTROPY, IMAGE);
  }

  interface Builder extends IFeaturedObject.Builder<Sampler> {
    Builder name(String name);
    Builder minFilter(EFilter minFilter);
    Builder magFilter(EFilter magFilter);
    Builder mipmapMode(ESamplerMipmapMode mipmapMode);
    Builder addressMode(ESamplerAddressMode addressMode);
    Builder borderColor(EBorderColor borderColor);
    Builder anisotropyEnabled(boolean anisotropyEnabled);
    Builder unnormalizedCoordinates(boolean unnormalizedCoordinates);
    Builder compareEnable(boolean compareEnable);
    Builder lodBias(float lodBias);
    Builder minLod(int minLod);
    Builder maxLod(int maxLod);
    Builder maxAnisotropy(float maxAnisotropy);
    Builder image(Supplier<IVulkanImage> image);
  }
}
