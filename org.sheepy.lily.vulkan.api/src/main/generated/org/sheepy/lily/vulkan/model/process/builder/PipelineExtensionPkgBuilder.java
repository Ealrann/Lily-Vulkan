package org.sheepy.lily.vulkan.model.process.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.process.IPipelineExtension;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg.Builder;
import org.sheepy.lily.vulkan.model.process.impl.PipelineExtensionPkgImpl;

public final class PipelineExtensionPkgBuilder implements Builder {
  private final List<Supplier<IPipelineExtension>> extensions = new ArrayList<>();

  public PipelineExtensionPkgBuilder() {
  }

  @Override
  public PipelineExtensionPkgBuilder addExtension(Supplier<IPipelineExtension> extension) {
    this.extensions.add(extension);
    return this;
  }

  @Override
  public PipelineExtensionPkgBuilder addExtensions(final List<IPipelineExtension> extensions) {
    extensions.forEach(value -> this.extensions.add(() -> value));
    return this;
  }

  @Override
  public PipelineExtensionPkg build() {
    final var builtExtensions = BuildUtils.collectSuppliers(extensions);
    final var built = new PipelineExtensionPkgImpl();
    built.extensions().addAll(builtExtensions);
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
    private static final FeatureInserter<PipelineExtensionPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PipelineExtensionPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<PipelineExtensionPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PipelineExtensionPkgBuilder>(1, Inserters::relationIndex).add(PipelineExtensionPkg.FeatureIDs.EXTENSIONS, (builder, value) -> builder.addExtension((Supplier<IPipelineExtension>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case PipelineExtensionPkg.FeatureIDs.EXTENSIONS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
