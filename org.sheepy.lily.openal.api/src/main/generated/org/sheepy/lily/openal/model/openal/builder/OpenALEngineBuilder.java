package org.sheepy.lily.openal.model.openal.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.openal.model.openal.OpenALEngine;
import org.sheepy.lily.openal.model.openal.OpenALEngine.Builder;
import org.sheepy.lily.openal.model.openal.impl.OpenALEngineImpl;

public final class OpenALEngineBuilder implements Builder {
  private Supplier<ResourcePkg> resourcePkg = () -> null;

  public OpenALEngineBuilder() {
  }

  @Override
  public OpenALEngineBuilder resourcePkg(Supplier<ResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public OpenALEngine build() {
    final var built = new OpenALEngineImpl();
    built.resourcePkg(resourcePkg.get());
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
    private static final FeatureInserter<OpenALEngineBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<OpenALEngineBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<OpenALEngineBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<OpenALEngineBuilder>(1, Inserters::relationIndex).add(OpenALEngine.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<ResourcePkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case OpenALEngine.FeatureIDs.RESOURCE_PKG -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
