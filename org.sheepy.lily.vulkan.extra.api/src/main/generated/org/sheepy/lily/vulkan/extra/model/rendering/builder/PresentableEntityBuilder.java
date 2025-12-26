package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector3dc;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl;

public final class PresentableEntityBuilder implements Builder {
  private String name;
  private Vector3dc location = ((Function<String, Vector3dc>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==3){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);return new org.joml.Vector3d(x,y,z);}}return new org.joml.Vector3d(0,0,0); }).apply("0;0;0");
  private Supplier<Axis> axis = () -> null;
  private Supplier<Presentation> presentation = () -> null;
  private double scale = 1;

  public PresentableEntityBuilder() {
  }

  @Override
  public PresentableEntityBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public PresentableEntityBuilder location(Vector3dc location) {
    this.location = location;
    return this;
  }

  @Override
  public PresentableEntityBuilder axis(Supplier<Axis> axis) {
    this.axis = axis;
    return this;
  }

  @Override
  public PresentableEntityBuilder presentation(Supplier<Presentation> presentation) {
    this.presentation = presentation;
    return this;
  }

  @Override
  public PresentableEntityBuilder scale(double scale) {
    this.scale = scale;
    return this;
  }

  @Override
  public PresentableEntity build() {
    final var built = new PresentableEntityImpl(name);
    built.location(location);
    built.axis(axis.get());
    built.presentation(presentation.get());
    built.scale(scale);
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
    private static final FeatureInserter<PresentableEntityBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PresentableEntityBuilder>(3, Inserters::attributeIndex).add(PresentableEntity.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(PresentableEntity.FeatureIDs.LOCATION, (builder, value) -> builder.location((Vector3dc) value)).add(PresentableEntity.FeatureIDs.SCALE, (builder, value) -> builder.scale((double) value)).build();
    private static final RelationLazyInserter<PresentableEntityBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PresentableEntityBuilder>(2, Inserters::relationIndex).add(PresentableEntity.FeatureIDs.AXIS, (builder, value) -> builder.axis((Supplier<Axis>) value)).add(PresentableEntity.FeatureIDs.PRESENTATION, (builder, value) -> builder.presentation((Supplier<Presentation>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case PresentableEntity.FeatureIDs.NAME -> 0;
        case PresentableEntity.FeatureIDs.LOCATION -> 1;
        case PresentableEntity.FeatureIDs.SCALE -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case PresentableEntity.FeatureIDs.AXIS -> 0;
        case PresentableEntity.FeatureIDs.PRESENTATION -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
