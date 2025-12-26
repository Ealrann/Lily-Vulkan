package org.sheepy.lily.vulkan.model.vulkanresource;

import java.nio.ByteBuffer;
import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.StaticImageBuilder;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;

public interface StaticImage extends IMemoryChunkPart, IVulkanImage, ImageInfo {
  static Builder builder() {
    return new StaticImageBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean fillWithZero();
  ByteBuffer fillWith();
  Vector2ic size();
  void fillWithZero(final boolean fillWithZero);
  void fillWith(final ByteBuffer fillWith);
  void size(final Vector2ic size);

  interface FeatureIDs {
    int FORMAT = ImageInfo.FeatureIDs.FORMAT;
    int USAGES = ImageInfo.FeatureIDs.USAGES;
    int TILING = ImageInfo.FeatureIDs.TILING;
    int MIP_LEVELS = ImageInfo.FeatureIDs.MIP_LEVELS;
    int INITIAL_LAYOUT = ImageInfo.FeatureIDs.INITIAL_LAYOUT;
    int NAME = Named.FeatureIDs.NAME;
    int FILL_WITH_ZERO = -355512535;
    int FILL_WITH = 528233697;
    int SIZE = 675164153;
  }

  interface Features<T extends Features<T>> extends IMemoryChunkPart.Features<T>, IVulkanImage.Features<T>, ImageInfo.Features<T> {
    Attribute<EFormat, EFormat, Listener<EFormat>, ImageInfo.Features<?>> FORMAT = ImageInfo.Features.FORMAT;
    Attribute<EImageUsage, List<EImageUsage>, Listener<List<EImageUsage>>, ImageInfo.Features<?>> USAGES = ImageInfo.Features.USAGES;
    Attribute<Integer, Integer, IntListener, ImageInfo.Features<?>> TILING = ImageInfo.Features.TILING;
    Attribute<Integer, Integer, IntListener, ImageInfo.Features<?>> MIP_LEVELS = ImageInfo.Features.MIP_LEVELS;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, ImageInfo.Features<?>> INITIAL_LAYOUT = ImageInfo.Features.INITIAL_LAYOUT;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> FILL_WITH_ZERO = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("fillWithZero").defaultValue("false").id(StaticImage.FeatureIDs.FILL_WITH_ZERO).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<ByteBuffer, ByteBuffer, Listener<ByteBuffer>, Features<?>> FILL_WITH = new AttributeBuilder<ByteBuffer, ByteBuffer, Listener<ByteBuffer>, Features<?>>().name("fillWith").id(StaticImage.FeatureIDs.FILL_WITH).datatype(() -> VulkanResourceModelDefinition.JavaWrappers.BYTE_BUFFER).build();
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>> SIZE = new AttributeBuilder<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>>().name("size").mandatory(true).defaultValue("1;1").id(StaticImage.FeatureIDs.SIZE).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR2I).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(FORMAT, USAGES, TILING, MIP_LEVELS, INITIAL_LAYOUT, NAME, FILL_WITH_ZERO, FILL_WITH, SIZE);
  }

  interface Builder extends IFeaturedObject.Builder<StaticImage> {
    Builder format(EFormat format);
    Builder addUsage(EImageUsage usage);
    Builder tiling(int tiling);
    Builder mipLevels(int mipLevels);
    Builder initialLayout(EImageLayout initialLayout);
    Builder name(String name);
    Builder fillWithZero(boolean fillWithZero);
    Builder fillWith(ByteBuffer fillWith);
    Builder size(Vector2ic size);
    Builder addUsages(List<EImageUsage> usages);
  }
}
