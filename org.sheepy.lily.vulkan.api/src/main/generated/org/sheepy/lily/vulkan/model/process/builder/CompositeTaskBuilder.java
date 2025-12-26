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
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.CompositeTask.Builder;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl;

public final class CompositeTaskBuilder implements Builder {
  private Supplier<Maintainer<CompositeTask>> maintainer = () -> null;
  private String name;
  private boolean enabled = true;
  private int repeatCount = 1;
  private final List<Supplier<IPipelineTask>> tasks = new ArrayList<>();

  public CompositeTaskBuilder() {
  }

  @Override
  public CompositeTaskBuilder maintainer(Supplier<Maintainer<CompositeTask>> maintainer) {
    this.maintainer = maintainer;
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private CompositeTaskBuilder _maintainer(final Supplier<Maintainer<?>> maintainer) {
    this.maintainer = (Supplier) maintainer;
    return this;
  }

  @Override
  public CompositeTaskBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CompositeTaskBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public CompositeTaskBuilder repeatCount(int repeatCount) {
    this.repeatCount = repeatCount;
    return this;
  }

  @Override
  public CompositeTaskBuilder addTask(Supplier<IPipelineTask> task) {
    this.tasks.add(task);
    return this;
  }

  @Override
  public CompositeTaskBuilder addTasks(final List<IPipelineTask> tasks) {
    tasks.forEach(value -> this.tasks.add(() -> value));
    return this;
  }

  @Override
  public CompositeTask build() {
    final var builtTasks = BuildUtils.collectSuppliers(tasks);
    final var built = new CompositeTaskImpl(name);
    built.maintainer(maintainer.get());
    built.enabled(enabled);
    built.repeatCount(repeatCount);
    built.tasks().addAll(builtTasks);
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
    private static final FeatureInserter<CompositeTaskBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CompositeTaskBuilder>(3, Inserters::attributeIndex).add(CompositeTask.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(CompositeTask.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(CompositeTask.FeatureIDs.REPEAT_COUNT, (builder, value) -> builder.repeatCount((int) value)).build();
    private static final RelationLazyInserter<CompositeTaskBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CompositeTaskBuilder>(2, Inserters::relationIndex).add(CompositeTask.FeatureIDs.MAINTAINER, (builder, value) -> builder._maintainer((Supplier<Maintainer<?>>) value)).add(CompositeTask.FeatureIDs.TASKS, (builder, value) -> builder.addTask((Supplier<IPipelineTask>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CompositeTask.FeatureIDs.NAME -> 0;
        case CompositeTask.FeatureIDs.ENABLED -> 1;
        case CompositeTask.FeatureIDs.REPEAT_COUNT -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case CompositeTask.FeatureIDs.MAINTAINER -> 0;
        case CompositeTask.FeatureIDs.TASKS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
