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
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.TaskPkg.Builder;
import org.sheepy.lily.vulkan.model.process.impl.TaskPkgImpl;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public final class TaskPkgBuilder implements Builder {
  private final List<Supplier<IPipelineTask>> tasks = new ArrayList<>();
  private ECommandStage stage = ECommandStage.MAIN;

  public TaskPkgBuilder() {
  }

  @Override
  public TaskPkgBuilder addTask(Supplier<IPipelineTask> task) {
    this.tasks.add(task);
    return this;
  }

  @Override
  public TaskPkgBuilder addTasks(final List<IPipelineTask> tasks) {
    tasks.forEach(value -> this.tasks.add(() -> value));
    return this;
  }

  @Override
  public TaskPkgBuilder stage(ECommandStage stage) {
    this.stage = stage;
    return this;
  }

  @Override
  public TaskPkg build() {
    final var builtTasks = BuildUtils.collectSuppliers(tasks);
    final var built = new TaskPkgImpl(stage);
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
    private static final FeatureInserter<TaskPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<TaskPkgBuilder>(1, Inserters::attributeIndex).add(TaskPkg.FeatureIDs.STAGE, (builder, value) -> builder.stage((ECommandStage) value)).build();
    private static final RelationLazyInserter<TaskPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<TaskPkgBuilder>(1, Inserters::relationIndex).add(TaskPkg.FeatureIDs.TASKS, (builder, value) -> builder.addTask((Supplier<IPipelineTask>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case TaskPkg.FeatureIDs.STAGE -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case TaskPkg.FeatureIDs.TASKS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
