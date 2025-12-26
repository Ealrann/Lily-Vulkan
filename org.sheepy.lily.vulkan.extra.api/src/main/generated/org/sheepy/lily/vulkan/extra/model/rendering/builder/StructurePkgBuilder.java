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
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.StructurePkg;
import org.sheepy.lily.vulkan.extra.model.rendering.StructurePkg.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.StructurePkgImpl;

public final class StructurePkgBuilder implements Builder {
  private final List<Supplier<Structure>> structures = new ArrayList<>();

  public StructurePkgBuilder() {
  }

  @Override
  public StructurePkgBuilder addStructure(Supplier<Structure> structure) {
    this.structures.add(structure);
    return this;
  }

  @Override
  public StructurePkgBuilder addStructures(final List<Structure> structures) {
    structures.forEach(value -> this.structures.add(() -> value));
    return this;
  }

  @Override
  public StructurePkg build() {
    final var builtStructures = BuildUtils.collectSuppliers(structures);
    final var built = new StructurePkgImpl();
    built.structures().addAll(builtStructures);
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
    private static final FeatureInserter<StructurePkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<StructurePkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<StructurePkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<StructurePkgBuilder>(1, Inserters::relationIndex).add(StructurePkg.FeatureIDs.STRUCTURES, (builder, value) -> builder.addStructure((Supplier<Structure>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case StructurePkg.FeatureIDs.STRUCTURES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
