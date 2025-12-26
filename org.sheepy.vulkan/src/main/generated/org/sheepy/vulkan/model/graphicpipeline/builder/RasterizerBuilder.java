package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.enumeration.ECullMode;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.enumeration.EPolygonMode;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl;

public final class RasterizerBuilder implements Builder {
  private ECullMode cullMode = ECullMode.BACK_BIT;
  private EFrontFace frontFace = EFrontFace.CLOCKWISE;
  private EPolygonMode polygonMode = EPolygonMode.FILL;
  private int lineWidth = 1;
  private boolean depthClampEnable = false;
  private boolean discardEnable = false;
  private boolean depthBiasEnable = false;

  public RasterizerBuilder() {
  }

  @Override
  public RasterizerBuilder cullMode(ECullMode cullMode) {
    this.cullMode = cullMode;
    return this;
  }

  @Override
  public RasterizerBuilder frontFace(EFrontFace frontFace) {
    this.frontFace = frontFace;
    return this;
  }

  @Override
  public RasterizerBuilder polygonMode(EPolygonMode polygonMode) {
    this.polygonMode = polygonMode;
    return this;
  }

  @Override
  public RasterizerBuilder lineWidth(int lineWidth) {
    this.lineWidth = lineWidth;
    return this;
  }

  @Override
  public RasterizerBuilder depthClampEnable(boolean depthClampEnable) {
    this.depthClampEnable = depthClampEnable;
    return this;
  }

  @Override
  public RasterizerBuilder discardEnable(boolean discardEnable) {
    this.discardEnable = discardEnable;
    return this;
  }

  @Override
  public RasterizerBuilder depthBiasEnable(boolean depthBiasEnable) {
    this.depthBiasEnable = depthBiasEnable;
    return this;
  }

  @Override
  public Rasterizer build() {
    final var built = new RasterizerImpl();
    built.cullMode(cullMode);
    built.frontFace(frontFace);
    built.polygonMode(polygonMode);
    built.lineWidth(lineWidth);
    built.depthClampEnable(depthClampEnable);
    built.discardEnable(discardEnable);
    built.depthBiasEnable(depthBiasEnable);
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
    private static final FeatureInserter<RasterizerBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<RasterizerBuilder>(7, Inserters::attributeIndex).add(Rasterizer.FeatureIDs.CULL_MODE, (builder, value) -> builder.cullMode((ECullMode) value)).add(Rasterizer.FeatureIDs.FRONT_FACE, (builder, value) -> builder.frontFace((EFrontFace) value)).add(Rasterizer.FeatureIDs.POLYGON_MODE, (builder, value) -> builder.polygonMode((EPolygonMode) value)).add(Rasterizer.FeatureIDs.LINE_WIDTH, (builder, value) -> builder.lineWidth((int) value)).add(Rasterizer.FeatureIDs.DEPTH_CLAMP_ENABLE, (builder, value) -> builder.depthClampEnable((boolean) value)).add(Rasterizer.FeatureIDs.DISCARD_ENABLE, (builder, value) -> builder.discardEnable((boolean) value)).add(Rasterizer.FeatureIDs.DEPTH_BIAS_ENABLE, (builder, value) -> builder.depthBiasEnable((boolean) value)).build();
    private static final RelationLazyInserter<RasterizerBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<RasterizerBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Rasterizer.FeatureIDs.CULL_MODE -> 0;
        case Rasterizer.FeatureIDs.FRONT_FACE -> 1;
        case Rasterizer.FeatureIDs.POLYGON_MODE -> 2;
        case Rasterizer.FeatureIDs.LINE_WIDTH -> 3;
        case Rasterizer.FeatureIDs.DEPTH_CLAMP_ENABLE -> 4;
        case Rasterizer.FeatureIDs.DISCARD_ENABLE -> 5;
        case Rasterizer.FeatureIDs.DEPTH_BIAS_ENABLE -> 6;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
