package org.sheepy.vulkan.model.image;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.EBorderColor;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.ESamplerAddressMode;
import org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.image.builder.SamplerInfoBuilder;

public interface SamplerInfo extends LMObject {
  static Builder builder() {
    return new SamplerInfoBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EFilter minFilter();
  EFilter magFilter();
  ESamplerMipmapMode mipmapMode();
  ESamplerAddressMode addressMode();
  EBorderColor borderColor();
  boolean anisotropyEnabled();
  boolean unnormalizedCoordinates();
  boolean compareEnable();
  float lodBias();
  int minLod();
  int maxLod();
  float maxAnisotropy();
  void minFilter(final EFilter minFilter);
  void magFilter(final EFilter magFilter);
  void mipmapMode(final ESamplerMipmapMode mipmapMode);
  void addressMode(final ESamplerAddressMode addressMode);
  void borderColor(final EBorderColor borderColor);
  void anisotropyEnabled(final boolean anisotropyEnabled);
  void unnormalizedCoordinates(final boolean unnormalizedCoordinates);
  void compareEnable(final boolean compareEnable);
  void lodBias(final float lodBias);
  void minLod(final int minLod);
  void maxLod(final int maxLod);
  void maxAnisotropy(final float maxAnisotropy);

  interface FeatureIDs {
    int MIN_FILTER = 1720916793;
    int MAG_FILTER = -1254222470;
    int MIPMAP_MODE = 1025879900;
    int ADDRESS_MODE = -1772553530;
    int BORDER_COLOR = 327766438;
    int ANISOTROPY_ENABLED = 452783982;
    int UNNORMALIZED_COORDINATES = -1317628390;
    int COMPARE_ENABLE = 1038389783;
    int LOD_BIAS = -39494615;
    int MIN_LOD = 1684689696;
    int MAX_LOD = 1677599438;
    int MAX_ANISOTROPY = -1127087851;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EFilter, EFilter, Listener<EFilter>, Features<?>> MIN_FILTER = new AttributeBuilder<EFilter, EFilter, Listener<EFilter>, Features<?>>().name("minFilter").defaultValue("NEAREST").id(SamplerInfo.FeatureIDs.MIN_FILTER).datatype(() -> EnumerationModelDefinition.Enums.E_FILTER).build();
    Attribute<EFilter, EFilter, Listener<EFilter>, Features<?>> MAG_FILTER = new AttributeBuilder<EFilter, EFilter, Listener<EFilter>, Features<?>>().name("magFilter").defaultValue("NEAREST").id(SamplerInfo.FeatureIDs.MAG_FILTER).datatype(() -> EnumerationModelDefinition.Enums.E_FILTER).build();
    Attribute<ESamplerMipmapMode, ESamplerMipmapMode, Listener<ESamplerMipmapMode>, Features<?>> MIPMAP_MODE = new AttributeBuilder<ESamplerMipmapMode, ESamplerMipmapMode, Listener<ESamplerMipmapMode>, Features<?>>().name("mipmapMode").defaultValue("NEAREST").id(SamplerInfo.FeatureIDs.MIPMAP_MODE).datatype(() -> EnumerationModelDefinition.Enums.E_SAMPLER_MIPMAP_MODE).build();
    Attribute<ESamplerAddressMode, ESamplerAddressMode, Listener<ESamplerAddressMode>, Features<?>> ADDRESS_MODE = new AttributeBuilder<ESamplerAddressMode, ESamplerAddressMode, Listener<ESamplerAddressMode>, Features<?>>().name("addressMode").defaultValue("REPEAT").id(SamplerInfo.FeatureIDs.ADDRESS_MODE).datatype(() -> EnumerationModelDefinition.Enums.E_SAMPLER_ADDRESS_MODE).build();
    Attribute<EBorderColor, EBorderColor, Listener<EBorderColor>, Features<?>> BORDER_COLOR = new AttributeBuilder<EBorderColor, EBorderColor, Listener<EBorderColor>, Features<?>>().name("borderColor").defaultValue("INT_OPAQUE_BLACK").id(SamplerInfo.FeatureIDs.BORDER_COLOR).datatype(() -> EnumerationModelDefinition.Enums.E_BORDER_COLOR).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ANISOTROPY_ENABLED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("anisotropyEnabled").defaultValue("false").id(SamplerInfo.FeatureIDs.ANISOTROPY_ENABLED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> UNNORMALIZED_COORDINATES = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("unnormalizedCoordinates").defaultValue("false").id(SamplerInfo.FeatureIDs.UNNORMALIZED_COORDINATES).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> COMPARE_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("compareEnable").defaultValue("false").id(SamplerInfo.FeatureIDs.COMPARE_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Float, Float, FloatListener, Features<?>> LOD_BIAS = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("lodBias").defaultValue("0f").id(SamplerInfo.FeatureIDs.LOD_BIAS).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> MIN_LOD = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("minLod").defaultValue("0").id(SamplerInfo.FeatureIDs.MIN_LOD).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> MAX_LOD = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("maxLod").defaultValue("1").id(SamplerInfo.FeatureIDs.MAX_LOD).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Float, Float, FloatListener, Features<?>> MAX_ANISOTROPY = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("maxAnisotropy").defaultValue("1f").id(SamplerInfo.FeatureIDs.MAX_ANISOTROPY).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MIN_FILTER, MAG_FILTER, MIPMAP_MODE, ADDRESS_MODE, BORDER_COLOR, ANISOTROPY_ENABLED, UNNORMALIZED_COORDINATES, COMPARE_ENABLE, LOD_BIAS, MIN_LOD, MAX_LOD, MAX_ANISOTROPY);
  }

  interface Builder extends IFeaturedObject.Builder<SamplerInfo> {
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
  }
}
