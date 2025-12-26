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
import org.sheepy.lily.vulkan.model.process.IProcessExtension;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg.Builder;
import org.sheepy.lily.vulkan.model.process.impl.ProcessExtensionPkgImpl;

public final class ProcessExtensionPkgBuilder implements Builder {
  private final List<Supplier<IProcessExtension>> extensions = new ArrayList<>();

  public ProcessExtensionPkgBuilder() {
  }

  @Override
  public ProcessExtensionPkgBuilder addExtension(Supplier<IProcessExtension> extension) {
    this.extensions.add(extension);
    return this;
  }

  @Override
  public ProcessExtensionPkgBuilder addExtensions(final List<IProcessExtension> extensions) {
    extensions.forEach(value -> this.extensions.add(() -> value));
    return this;
  }

  @Override
  public ProcessExtensionPkg build() {
    final var builtExtensions = BuildUtils.collectSuppliers(extensions);
    final var built = new ProcessExtensionPkgImpl();
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
    private static final FeatureInserter<ProcessExtensionPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ProcessExtensionPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ProcessExtensionPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ProcessExtensionPkgBuilder>(1, Inserters::relationIndex).add(ProcessExtensionPkg.FeatureIDs.EXTENSIONS, (builder, value) -> builder.addExtension((Supplier<IProcessExtension>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ProcessExtensionPkg.FeatureIDs.EXTENSIONS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
