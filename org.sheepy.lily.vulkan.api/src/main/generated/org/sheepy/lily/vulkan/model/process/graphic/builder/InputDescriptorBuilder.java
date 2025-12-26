package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription;
import org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.InputDescriptorImpl;
import org.sheepy.vulkan.model.enumeration.EInputRate;

public final class InputDescriptorBuilder implements Builder {
  private EInputRate inputRate = EInputRate.VERTEX;
  private int strideLength;
  private final List<Supplier<AttributeDescription>> attributes = new ArrayList<>();

  public InputDescriptorBuilder() {
  }

  @Override
  public InputDescriptorBuilder inputRate(EInputRate inputRate) {
    this.inputRate = inputRate;
    return this;
  }

  @Override
  public InputDescriptorBuilder strideLength(int strideLength) {
    this.strideLength = strideLength;
    return this;
  }

  @Override
  public InputDescriptorBuilder addAttribute(Supplier<AttributeDescription> attribute) {
    this.attributes.add(attribute);
    return this;
  }

  @Override
  public InputDescriptorBuilder addAttributes(final List<AttributeDescription> attributes) {
    attributes.forEach(value -> this.attributes.add(() -> value));
    return this;
  }

  @Override
  public InputDescriptor build() {
    final var builtAttributes = BuildUtils.collectSuppliers(attributes);
    final var built = new InputDescriptorImpl(builtAttributes);
    built.inputRate(inputRate);
    built.strideLength(strideLength);
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
    private static final FeatureInserter<InputDescriptorBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<InputDescriptorBuilder>(2, Inserters::attributeIndex).add(InputDescriptor.FeatureIDs.INPUT_RATE, (builder, value) -> builder.inputRate((EInputRate) value)).add(InputDescriptor.FeatureIDs.STRIDE_LENGTH, (builder, value) -> builder.strideLength((int) value)).build();
    private static final RelationLazyInserter<InputDescriptorBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<InputDescriptorBuilder>(1, Inserters::relationIndex).add(InputDescriptor.FeatureIDs.ATTRIBUTES, (builder, value) -> builder.addAttribute((Supplier<AttributeDescription>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case InputDescriptor.FeatureIDs.INPUT_RATE -> 0;
        case InputDescriptor.FeatureIDs.STRIDE_LENGTH -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case InputDescriptor.FeatureIDs.ATTRIBUTES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
