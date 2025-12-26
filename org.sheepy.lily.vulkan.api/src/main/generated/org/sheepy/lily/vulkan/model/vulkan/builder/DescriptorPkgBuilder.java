package org.sheepy.lily.vulkan.model.vulkan.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg.Builder;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkan.impl.DescriptorPkgImpl;

public final class DescriptorPkgBuilder implements Builder {
  private final List<Supplier<IDescriptor>> descriptors = new ArrayList<>();

  public DescriptorPkgBuilder() {
  }

  @Override
  public DescriptorPkgBuilder addDescriptor(Supplier<IDescriptor> descriptor) {
    this.descriptors.add(descriptor);
    return this;
  }

  @Override
  public DescriptorPkgBuilder addDescriptors(final List<IDescriptor> descriptors) {
    descriptors.forEach(value -> this.descriptors.add(() -> value));
    return this;
  }

  @Override
  public DescriptorPkg build() {
    final var builtDescriptors = BuildUtils.collectSuppliers(descriptors);
    final var built = new DescriptorPkgImpl();
    built.descriptors().addAll(builtDescriptors);
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
    private static final FeatureInserter<DescriptorPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DescriptorPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<DescriptorPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DescriptorPkgBuilder>(1, Inserters::relationIndex).add(DescriptorPkg.FeatureIDs.DESCRIPTORS, (builder, value) -> builder.addDescriptor((Supplier<IDescriptor>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case DescriptorPkg.FeatureIDs.DESCRIPTORS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
