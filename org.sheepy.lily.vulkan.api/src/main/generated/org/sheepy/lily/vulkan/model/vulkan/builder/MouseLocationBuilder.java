package org.sheepy.lily.vulkan.model.vulkan.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkan.MouseLocation;
import org.sheepy.lily.vulkan.model.vulkan.MouseLocation.Builder;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.lily.vulkan.model.vulkan.impl.MouseLocationImpl;

public final class MouseLocationBuilder implements Builder {
  private String name;
  private Supplier<VulkanEngine> vulkanEngine;

  public MouseLocationBuilder() {
  }

  @Override
  public MouseLocationBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public MouseLocationBuilder vulkanEngine(Supplier<VulkanEngine> vulkanEngine) {
    this.vulkanEngine = vulkanEngine;
    return this;
  }

  @Override
  public MouseLocation build() {
    final var built = new MouseLocationImpl(name, vulkanEngine.get());
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
    private static final FeatureInserter<MouseLocationBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<MouseLocationBuilder>(1, Inserters::attributeIndex).add(MouseLocation.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<MouseLocationBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<MouseLocationBuilder>(1, Inserters::relationIndex).add(MouseLocation.FeatureIDs.VULKAN_ENGINE, (builder, value) -> builder.vulkanEngine((Supplier<VulkanEngine>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case MouseLocation.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case MouseLocation.FeatureIDs.VULKAN_ENGINE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
