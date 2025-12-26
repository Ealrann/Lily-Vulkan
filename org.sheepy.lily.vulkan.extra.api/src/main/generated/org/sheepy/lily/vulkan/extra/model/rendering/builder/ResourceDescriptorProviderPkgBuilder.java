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
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.ResourceDescriptorProviderPkgImpl;

public final class ResourceDescriptorProviderPkgBuilder implements Builder {
  private final List<Supplier<ResourceDescriptorProvider>> resourceDescriptorProviders = new ArrayList<>();

  public ResourceDescriptorProviderPkgBuilder() {
  }

  @Override
  public ResourceDescriptorProviderPkgBuilder addResourceDescriptorProvider(
      Supplier<ResourceDescriptorProvider> resourceDescriptorProvider) {
    this.resourceDescriptorProviders.add(resourceDescriptorProvider);
    return this;
  }

  @Override
  public ResourceDescriptorProviderPkgBuilder addResourceDescriptorProviders(
      final List<ResourceDescriptorProvider> resourceDescriptorProviders) {
    resourceDescriptorProviders.forEach(value -> this.resourceDescriptorProviders.add(() -> value));
    return this;
  }

  @Override
  public ResourceDescriptorProviderPkg build() {
    final var builtResourceDescriptorProviders = BuildUtils.collectSuppliers(resourceDescriptorProviders);
    final var built = new ResourceDescriptorProviderPkgImpl();
    built.resourceDescriptorProviders().addAll(builtResourceDescriptorProviders);
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
    private static final FeatureInserter<ResourceDescriptorProviderPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ResourceDescriptorProviderPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ResourceDescriptorProviderPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ResourceDescriptorProviderPkgBuilder>(1, Inserters::relationIndex).add(ResourceDescriptorProviderPkg.FeatureIDs.RESOURCE_DESCRIPTOR_PROVIDERS, (builder, value) -> builder.addResourceDescriptorProvider((Supplier<ResourceDescriptorProvider>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ResourceDescriptorProviderPkg.FeatureIDs.RESOURCE_DESCRIPTOR_PROVIDERS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
