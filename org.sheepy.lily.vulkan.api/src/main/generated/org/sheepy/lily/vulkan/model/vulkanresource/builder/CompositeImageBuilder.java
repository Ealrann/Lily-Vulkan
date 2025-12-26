package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage;
import org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.CompositeImageImpl;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

public final class CompositeImageBuilder implements Builder {
  private EFormat format = EFormat.R8G8B8A8_UNORM;
  private final List<EImageUsage> usages = new ArrayList<>();
  private int tiling = 0;
  private int mipLevels = 1;
  private EImageLayout initialLayout = EImageLayout.SHADER_READ_ONLY_OPTIMAL;
  private String name;
  private final List<Supplier<ImageInlay>> inlays = new ArrayList<>();
  private Supplier<IVulkanImage> background;

  public CompositeImageBuilder() {
  }

  @Override
  public CompositeImageBuilder format(EFormat format) {
    this.format = format;
    return this;
  }

  @Override
  public CompositeImageBuilder addUsage(EImageUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public CompositeImageBuilder addUsages(final List<EImageUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public CompositeImageBuilder tiling(int tiling) {
    this.tiling = tiling;
    return this;
  }

  @Override
  public CompositeImageBuilder mipLevels(int mipLevels) {
    this.mipLevels = mipLevels;
    return this;
  }

  @Override
  public CompositeImageBuilder initialLayout(EImageLayout initialLayout) {
    this.initialLayout = initialLayout;
    return this;
  }

  @Override
  public CompositeImageBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CompositeImageBuilder addInlay(Supplier<ImageInlay> inlay) {
    this.inlays.add(inlay);
    return this;
  }

  @Override
  public CompositeImageBuilder addInlays(final List<ImageInlay> inlays) {
    inlays.forEach(value -> this.inlays.add(() -> value));
    return this;
  }

  @Override
  public CompositeImageBuilder background(Supplier<IVulkanImage> background) {
    this.background = background;
    return this;
  }

  @Override
  public CompositeImage build() {
    final var builtInlays = BuildUtils.collectSuppliers(inlays);
    final var built = new CompositeImageImpl(format, usages, tiling, mipLevels, name, background.get());
    built.initialLayout(initialLayout);
    built.inlays().addAll(builtInlays);
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
    private static final FeatureInserter<CompositeImageBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CompositeImageBuilder>(6, Inserters::attributeIndex).add(CompositeImage.FeatureIDs.FORMAT, (builder, value) -> builder.format((EFormat) value)).add(CompositeImage.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EImageUsage) value)).add(CompositeImage.FeatureIDs.TILING, (builder, value) -> builder.tiling((int) value)).add(CompositeImage.FeatureIDs.MIP_LEVELS, (builder, value) -> builder.mipLevels((int) value)).add(CompositeImage.FeatureIDs.INITIAL_LAYOUT, (builder, value) -> builder.initialLayout((EImageLayout) value)).add(CompositeImage.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<CompositeImageBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CompositeImageBuilder>(2, Inserters::relationIndex).add(CompositeImage.FeatureIDs.INLAYS, (builder, value) -> builder.addInlay((Supplier<ImageInlay>) value)).add(CompositeImage.FeatureIDs.BACKGROUND, (builder, value) -> builder.background((Supplier<IVulkanImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CompositeImage.FeatureIDs.FORMAT -> 0;
        case CompositeImage.FeatureIDs.USAGES -> 1;
        case CompositeImage.FeatureIDs.TILING -> 2;
        case CompositeImage.FeatureIDs.MIP_LEVELS -> 3;
        case CompositeImage.FeatureIDs.INITIAL_LAYOUT -> 4;
        case CompositeImage.FeatureIDs.NAME -> 5;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case CompositeImage.FeatureIDs.INLAYS -> 0;
        case CompositeImage.FeatureIDs.BACKGROUND -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
