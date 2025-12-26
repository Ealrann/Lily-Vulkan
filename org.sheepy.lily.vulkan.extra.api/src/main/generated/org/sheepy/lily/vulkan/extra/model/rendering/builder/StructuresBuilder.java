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
import org.sheepy.lily.vulkan.extra.model.rendering.StructurePkg;
import org.sheepy.lily.vulkan.extra.model.rendering.Structures;
import org.sheepy.lily.vulkan.extra.model.rendering.Structures.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.StructuresImpl;

public final class StructuresBuilder implements Builder {
  private final List<Supplier<StructurePkg>> structurePkgs = new ArrayList<>();

  public StructuresBuilder() {
  }

  @Override
  public StructuresBuilder addStructurePkg(Supplier<StructurePkg> structurePkg) {
    this.structurePkgs.add(structurePkg);
    return this;
  }

  @Override
  public StructuresBuilder addStructurePkgs(final List<StructurePkg> structurePkgs) {
    structurePkgs.forEach(value -> this.structurePkgs.add(() -> value));
    return this;
  }

  @Override
  public Structures build() {
    final var builtStructurePkgs = BuildUtils.collectSuppliers(structurePkgs);
    final var built = new StructuresImpl();
    built.structurePkgs().addAll(builtStructurePkgs);
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
    private static final FeatureInserter<StructuresBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<StructuresBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<StructuresBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<StructuresBuilder>(1, Inserters::relationIndex).add(Structures.FeatureIDs.STRUCTURE_PKGS, (builder, value) -> builder.addStructurePkg((Supplier<StructurePkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Structures.FeatureIDs.STRUCTURE_PKGS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
