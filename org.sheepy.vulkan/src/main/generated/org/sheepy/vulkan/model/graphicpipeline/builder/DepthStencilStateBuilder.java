package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.enumeration.ECompareOp;
import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;
import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl;

public final class DepthStencilStateBuilder implements Builder {
  private boolean depthTest = true;
  private boolean depthWrite = true;
  private boolean depthBoundTest = false;
  private boolean stencilTest = false;
  private ECompareOp depthCompareOp = ECompareOp.LESS;
  private float minDepthBounds = 0f;
  private float maxDepthBounds = 1f;

  public DepthStencilStateBuilder() {
  }

  @Override
  public DepthStencilStateBuilder depthTest(boolean depthTest) {
    this.depthTest = depthTest;
    return this;
  }

  @Override
  public DepthStencilStateBuilder depthWrite(boolean depthWrite) {
    this.depthWrite = depthWrite;
    return this;
  }

  @Override
  public DepthStencilStateBuilder depthBoundTest(boolean depthBoundTest) {
    this.depthBoundTest = depthBoundTest;
    return this;
  }

  @Override
  public DepthStencilStateBuilder stencilTest(boolean stencilTest) {
    this.stencilTest = stencilTest;
    return this;
  }

  @Override
  public DepthStencilStateBuilder depthCompareOp(ECompareOp depthCompareOp) {
    this.depthCompareOp = depthCompareOp;
    return this;
  }

  @Override
  public DepthStencilStateBuilder minDepthBounds(float minDepthBounds) {
    this.minDepthBounds = minDepthBounds;
    return this;
  }

  @Override
  public DepthStencilStateBuilder maxDepthBounds(float maxDepthBounds) {
    this.maxDepthBounds = maxDepthBounds;
    return this;
  }

  @Override
  public DepthStencilState build() {
    final var built = new DepthStencilStateImpl(depthTest, depthWrite, depthBoundTest, stencilTest, depthCompareOp, minDepthBounds, maxDepthBounds);
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
    private static final FeatureInserter<DepthStencilStateBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DepthStencilStateBuilder>(7, Inserters::attributeIndex).add(DepthStencilState.FeatureIDs.DEPTH_TEST, (builder, value) -> builder.depthTest((boolean) value)).add(DepthStencilState.FeatureIDs.DEPTH_WRITE, (builder, value) -> builder.depthWrite((boolean) value)).add(DepthStencilState.FeatureIDs.DEPTH_BOUND_TEST, (builder, value) -> builder.depthBoundTest((boolean) value)).add(DepthStencilState.FeatureIDs.STENCIL_TEST, (builder, value) -> builder.stencilTest((boolean) value)).add(DepthStencilState.FeatureIDs.DEPTH_COMPARE_OP, (builder, value) -> builder.depthCompareOp((ECompareOp) value)).add(DepthStencilState.FeatureIDs.MIN_DEPTH_BOUNDS, (builder, value) -> builder.minDepthBounds((float) value)).add(DepthStencilState.FeatureIDs.MAX_DEPTH_BOUNDS, (builder, value) -> builder.maxDepthBounds((float) value)).build();
    private static final RelationLazyInserter<DepthStencilStateBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DepthStencilStateBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DepthStencilState.FeatureIDs.DEPTH_TEST -> 0;
        case DepthStencilState.FeatureIDs.DEPTH_WRITE -> 1;
        case DepthStencilState.FeatureIDs.DEPTH_BOUND_TEST -> 2;
        case DepthStencilState.FeatureIDs.STENCIL_TEST -> 3;
        case DepthStencilState.FeatureIDs.DEPTH_COMPARE_OP -> 4;
        case DepthStencilState.FeatureIDs.MIN_DEPTH_BOUNDS -> 5;
        case DepthStencilState.FeatureIDs.MAX_DEPTH_BOUNDS -> 6;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
