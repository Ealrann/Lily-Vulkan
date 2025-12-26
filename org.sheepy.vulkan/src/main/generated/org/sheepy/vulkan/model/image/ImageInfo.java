package org.sheepy.vulkan.model.image;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.image.builder.ImageInfoBuilder;

public interface ImageInfo extends LMObject {
  static Builder builder() {
    return new ImageInfoBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EFormat format();
  List<EImageUsage> usages();
  int tiling();
  int mipLevels();
  EImageLayout initialLayout();
  void format(final EFormat format);
  void tiling(final int tiling);
  void mipLevels(final int mipLevels);
  void initialLayout(final EImageLayout initialLayout);

  interface FeatureIDs {
    int FORMAT = -1653404779;
    int USAGES = -1220785520;
    int TILING = -1258319991;
    int MIP_LEVELS = -1951975291;
    int INITIAL_LAYOUT = 147257904;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EFormat, EFormat, Listener<EFormat>, Features<?>> FORMAT = new AttributeBuilder<EFormat, EFormat, Listener<EFormat>, Features<?>>().name("format").mandatory(true).defaultValue("R8G8B8A8_UNORM").id(ImageInfo.FeatureIDs.FORMAT).datatype(() -> EnumerationModelDefinition.Enums.E_FORMAT).build();
    Attribute<EImageUsage, List<EImageUsage>, Listener<List<EImageUsage>>, Features<?>> USAGES = new AttributeBuilder<EImageUsage, List<EImageUsage>, Listener<List<EImageUsage>>, Features<?>>().name("usages").many(true).mandatory(true).id(ImageInfo.FeatureIDs.USAGES).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_USAGE).build();
    Attribute<Integer, Integer, IntListener, Features<?>> TILING = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("tiling").mandatory(true).defaultValue("0").id(ImageInfo.FeatureIDs.TILING).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> MIP_LEVELS = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("mipLevels").mandatory(true).defaultValue("1").id(ImageInfo.FeatureIDs.MIP_LEVELS).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> INITIAL_LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("initialLayout").defaultValue("SHADER_READ_ONLY_OPTIMAL").id(ImageInfo.FeatureIDs.INITIAL_LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(FORMAT, USAGES, TILING, MIP_LEVELS, INITIAL_LAYOUT);
  }

  interface Builder extends IFeaturedObject.Builder<ImageInfo> {
    Builder format(EFormat format);
    Builder addUsage(EImageUsage usage);
    Builder tiling(int tiling);
    Builder mipLevels(int mipLevels);
    Builder initialLayout(EImageLayout initialLayout);
    Builder addUsages(List<EImageUsage> usages);
  }
}
