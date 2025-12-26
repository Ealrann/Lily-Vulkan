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
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg.Builder;
import org.sheepy.lily.vulkan.model.vulkan.impl.VulkanResourcePkgImpl;

public final class VulkanResourcePkgBuilder implements Builder {
  private final List<Supplier<IVulkanResource>> resources = new ArrayList<>();

  public VulkanResourcePkgBuilder() {
  }

  @Override
  public VulkanResourcePkgBuilder addResource(Supplier<IVulkanResource> resource) {
    this.resources.add(resource);
    return this;
  }

  @Override
  public VulkanResourcePkgBuilder addResources(final List<IVulkanResource> resources) {
    resources.forEach(value -> this.resources.add(() -> value));
    return this;
  }

  @Override
  public VulkanResourcePkg build() {
    final var builtResources = BuildUtils.collectSuppliers(resources);
    final var built = new VulkanResourcePkgImpl();
    built.resources().addAll(builtResources);
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
    private static final FeatureInserter<VulkanResourcePkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<VulkanResourcePkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<VulkanResourcePkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<VulkanResourcePkgBuilder>(1, Inserters::relationIndex).add(VulkanResourcePkg.FeatureIDs.RESOURCES, (builder, value) -> builder.addResource((Supplier<IVulkanResource>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case VulkanResourcePkg.FeatureIDs.RESOURCES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
