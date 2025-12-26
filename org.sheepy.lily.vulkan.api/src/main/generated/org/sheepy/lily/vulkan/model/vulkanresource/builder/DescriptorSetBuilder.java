package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorSetImpl;

public final class DescriptorSetBuilder implements Builder {
  private String name;
  private final List<Supplier<IDescriptor>> descriptors = new ArrayList<>();

  public DescriptorSetBuilder() {
  }

  @Override
  public DescriptorSetBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public DescriptorSetBuilder addDescriptor(Supplier<IDescriptor> descriptor) {
    this.descriptors.add(descriptor);
    return this;
  }

  @Override
  public DescriptorSetBuilder addDescriptors(final List<IDescriptor> descriptors) {
    descriptors.forEach(value -> this.descriptors.add(() -> value));
    return this;
  }

  @Override
  public DescriptorSet build() {
    final var builtDescriptors = BuildUtils.collectSuppliers(descriptors);
    final var built = new DescriptorSetImpl(name, builtDescriptors);
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
    private static final FeatureInserter<DescriptorSetBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DescriptorSetBuilder>(1, Inserters::attributeIndex).add(DescriptorSet.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<DescriptorSetBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DescriptorSetBuilder>(1, Inserters::relationIndex).add(DescriptorSet.FeatureIDs.DESCRIPTORS, (builder, value) -> builder.addDescriptor((Supplier<IDescriptor>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DescriptorSet.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case DescriptorSet.FeatureIDs.DESCRIPTORS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
