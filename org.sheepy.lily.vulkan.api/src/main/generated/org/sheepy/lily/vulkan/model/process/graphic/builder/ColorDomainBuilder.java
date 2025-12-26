package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ColorDomainImpl;
import org.sheepy.vulkan.model.enumeration.EColorSpace;
import org.sheepy.vulkan.model.enumeration.EFormat;

public final class ColorDomainBuilder implements Builder {
  private EFormat format = EFormat.B8G8R8A8_UNORM;
  private EColorSpace colorSpace = EColorSpace.SRGB_NONLINEAR_KHR;

  public ColorDomainBuilder() {
  }

  @Override
  public ColorDomainBuilder format(EFormat format) {
    this.format = format;
    return this;
  }

  @Override
  public ColorDomainBuilder colorSpace(EColorSpace colorSpace) {
    this.colorSpace = colorSpace;
    return this;
  }

  @Override
  public ColorDomain build() {
    final var built = new ColorDomainImpl();
    built.format(format);
    built.colorSpace(colorSpace);
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
    private static final FeatureInserter<ColorDomainBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ColorDomainBuilder>(2, Inserters::attributeIndex).add(ColorDomain.FeatureIDs.FORMAT, (builder, value) -> builder.format((EFormat) value)).add(ColorDomain.FeatureIDs.COLOR_SPACE, (builder, value) -> builder.colorSpace((EColorSpace) value)).build();
    private static final RelationLazyInserter<ColorDomainBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ColorDomainBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ColorDomain.FeatureIDs.FORMAT -> 0;
        case ColorDomain.FeatureIDs.COLOR_SPACE -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
