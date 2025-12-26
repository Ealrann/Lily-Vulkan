package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticImageImpl;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

public final class StaticImageBuilder implements Builder {
  private EFormat format = EFormat.R8G8B8A8_UNORM;
  private final List<EImageUsage> usages = new ArrayList<>();
  private int tiling = 0;
  private int mipLevels = 1;
  private EImageLayout initialLayout = EImageLayout.SHADER_READ_ONLY_OPTIMAL;
  private String name;
  private boolean fillWithZero = false;
  private ByteBuffer fillWith;
  private Vector2ic size = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("1;1");

  public StaticImageBuilder() {
  }

  @Override
  public StaticImageBuilder format(EFormat format) {
    this.format = format;
    return this;
  }

  @Override
  public StaticImageBuilder addUsage(EImageUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public StaticImageBuilder addUsages(final List<EImageUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public StaticImageBuilder tiling(int tiling) {
    this.tiling = tiling;
    return this;
  }

  @Override
  public StaticImageBuilder mipLevels(int mipLevels) {
    this.mipLevels = mipLevels;
    return this;
  }

  @Override
  public StaticImageBuilder initialLayout(EImageLayout initialLayout) {
    this.initialLayout = initialLayout;
    return this;
  }

  @Override
  public StaticImageBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public StaticImageBuilder fillWithZero(boolean fillWithZero) {
    this.fillWithZero = fillWithZero;
    return this;
  }

  @Override
  public StaticImageBuilder fillWith(ByteBuffer fillWith) {
    this.fillWith = fillWith;
    return this;
  }

  @Override
  public StaticImageBuilder size(Vector2ic size) {
    this.size = size;
    return this;
  }

  @Override
  public StaticImage build() {
    final var built = new StaticImageImpl(format, usages, tiling, mipLevels, name, size);
    built.initialLayout(initialLayout);
    built.fillWithZero(fillWithZero);
    built.fillWith(fillWith);
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
    private static final FeatureInserter<StaticImageBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<StaticImageBuilder>(9, Inserters::attributeIndex).add(StaticImage.FeatureIDs.FORMAT, (builder, value) -> builder.format((EFormat) value)).add(StaticImage.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EImageUsage) value)).add(StaticImage.FeatureIDs.TILING, (builder, value) -> builder.tiling((int) value)).add(StaticImage.FeatureIDs.MIP_LEVELS, (builder, value) -> builder.mipLevels((int) value)).add(StaticImage.FeatureIDs.INITIAL_LAYOUT, (builder, value) -> builder.initialLayout((EImageLayout) value)).add(StaticImage.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(StaticImage.FeatureIDs.FILL_WITH_ZERO, (builder, value) -> builder.fillWithZero((boolean) value)).add(StaticImage.FeatureIDs.FILL_WITH, (builder, value) -> builder.fillWith((ByteBuffer) value)).add(StaticImage.FeatureIDs.SIZE, (builder, value) -> builder.size((Vector2ic) value)).build();
    private static final RelationLazyInserter<StaticImageBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<StaticImageBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case StaticImage.FeatureIDs.FORMAT -> 0;
        case StaticImage.FeatureIDs.USAGES -> 1;
        case StaticImage.FeatureIDs.TILING -> 2;
        case StaticImage.FeatureIDs.MIP_LEVELS -> 3;
        case StaticImage.FeatureIDs.INITIAL_LAYOUT -> 4;
        case StaticImage.FeatureIDs.NAME -> 5;
        case StaticImage.FeatureIDs.FILL_WITH_ZERO -> 6;
        case StaticImage.FeatureIDs.FILL_WITH -> 7;
        case StaticImage.FeatureIDs.SIZE -> 8;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
