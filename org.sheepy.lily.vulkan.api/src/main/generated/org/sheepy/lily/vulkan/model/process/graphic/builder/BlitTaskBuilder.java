package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector3ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.BlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.BlitTask.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.BlitTaskImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.vulkan.model.enumeration.EFilter;

public final class BlitTaskBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private EFilter filter = EFilter.NEAREST;
  private Vector3ic clearColor = ((Function<String, Vector3ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==3){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);return new org.joml.Vector3i(x,y,z);}}return new org.joml.Vector3i(0,0,0); }).apply("0;0;0");
  private Supplier<IVulkanImage> srcImage = () -> null;
  private Supplier<IVulkanImage> dstImage = () -> null;

  public BlitTaskBuilder() {
  }

  @Override
  public BlitTaskBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BlitTaskBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public BlitTaskBuilder filter(EFilter filter) {
    this.filter = filter;
    return this;
  }

  @Override
  public BlitTaskBuilder clearColor(Vector3ic clearColor) {
    this.clearColor = clearColor;
    return this;
  }

  @Override
  public BlitTaskBuilder srcImage(Supplier<IVulkanImage> srcImage) {
    this.srcImage = srcImage;
    return this;
  }

  @Override
  public BlitTaskBuilder dstImage(Supplier<IVulkanImage> dstImage) {
    this.dstImage = dstImage;
    return this;
  }

  @Override
  public BlitTask build() {
    final var built = new BlitTaskImpl(name, clearColor);
    built.enabled(enabled);
    built.filter(filter);
    built.srcImage(srcImage.get());
    built.dstImage(dstImage.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<BlitTaskBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BlitTaskBuilder>(4, Inserters::attributeIndex).add(BlitTask.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(BlitTask.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(BlitTask.FeatureIDs.FILTER, (builder, value) -> builder.filter((EFilter) value)).add(BlitTask.FeatureIDs.CLEAR_COLOR, (builder, value) -> builder.clearColor((Vector3ic) value)).build();
    private static final RelationLazyInserter<BlitTaskBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BlitTaskBuilder>(2, Inserters::relationIndex).add(BlitTask.FeatureIDs.SRC_IMAGE, (builder, value) -> builder.srcImage((Supplier<IVulkanImage>) value)).add(BlitTask.FeatureIDs.DST_IMAGE, (builder, value) -> builder.dstImage((Supplier<IVulkanImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BlitTask.FeatureIDs.NAME -> 0;
        case BlitTask.FeatureIDs.ENABLED -> 1;
        case BlitTask.FeatureIDs.FILTER -> 2;
        case BlitTask.FeatureIDs.CLEAR_COLOR -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BlitTask.FeatureIDs.SRC_IMAGE -> 0;
        case BlitTask.FeatureIDs.DST_IMAGE -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
