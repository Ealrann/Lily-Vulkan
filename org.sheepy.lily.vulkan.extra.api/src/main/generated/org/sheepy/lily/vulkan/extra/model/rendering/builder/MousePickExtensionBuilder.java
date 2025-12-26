package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.MousePickExtensionImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;

public final class MousePickExtensionBuilder implements Builder {
  private Supplier<StaticBuffer> mousePickBuffer;
  private Supplier<SelectionProxy> selectionProxy = () -> null;
  private final List<Supplier<EntityResolverPipeline>> entityResolverPipelines = new ArrayList<>();
  private int resolverPipelineOffset = 0;

  public MousePickExtensionBuilder() {
  }

  @Override
  public MousePickExtensionBuilder mousePickBuffer(Supplier<StaticBuffer> mousePickBuffer) {
    this.mousePickBuffer = mousePickBuffer;
    return this;
  }

  @Override
  public MousePickExtensionBuilder selectionProxy(Supplier<SelectionProxy> selectionProxy) {
    this.selectionProxy = selectionProxy;
    return this;
  }

  @Override
  public MousePickExtensionBuilder addEntityResolverPipeline(
      Supplier<EntityResolverPipeline> entityResolverPipeline) {
    this.entityResolverPipelines.add(entityResolverPipeline);
    return this;
  }

  @Override
  public MousePickExtensionBuilder addEntityResolverPipelines(
      final List<EntityResolverPipeline> entityResolverPipelines) {
    entityResolverPipelines.forEach(value -> this.entityResolverPipelines.add(() -> value));
    return this;
  }

  @Override
  public MousePickExtensionBuilder resolverPipelineOffset(int resolverPipelineOffset) {
    this.resolverPipelineOffset = resolverPipelineOffset;
    return this;
  }

  @Override
  public MousePickExtension build() {
    final var builtEntityResolverPipelines = BuildUtils.collectSuppliers(entityResolverPipelines);
    final var built = new MousePickExtensionImpl(mousePickBuffer.get(), resolverPipelineOffset);
    built.selectionProxy(selectionProxy.get());
    built.entityResolverPipelines().addAll(builtEntityResolverPipelines);
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
    private static final FeatureInserter<MousePickExtensionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<MousePickExtensionBuilder>(1, Inserters::attributeIndex).add(MousePickExtension.FeatureIDs.RESOLVER_PIPELINE_OFFSET, (builder, value) -> builder.resolverPipelineOffset((int) value)).build();
    private static final RelationLazyInserter<MousePickExtensionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<MousePickExtensionBuilder>(3, Inserters::relationIndex).add(MousePickExtension.FeatureIDs.MOUSE_PICK_BUFFER, (builder, value) -> builder.mousePickBuffer((Supplier<StaticBuffer>) value)).add(MousePickExtension.FeatureIDs.SELECTION_PROXY, (builder, value) -> builder.selectionProxy((Supplier<SelectionProxy>) value)).add(MousePickExtension.FeatureIDs.ENTITY_RESOLVER_PIPELINES, (builder, value) -> builder.addEntityResolverPipeline((Supplier<EntityResolverPipeline>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case MousePickExtension.FeatureIDs.RESOLVER_PIPELINE_OFFSET -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case MousePickExtension.FeatureIDs.MOUSE_PICK_BUFFER -> 0;
        case MousePickExtension.FeatureIDs.SELECTION_PROXY -> 1;
        case MousePickExtension.FeatureIDs.ENTITY_RESOLVER_PIPELINES -> 2;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
