package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.StaticViewportStateBuilder;

public interface StaticViewportState extends ViewportState {
  static Builder builder() {
    return new StaticViewportStateBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IViewport> viewports();
  List<Scissor> scissors();

  interface FeatureIDs {
    int VIEWPORTS = 181575698;
    int SCISSORS = -1708201998;
  }

  interface Features<T extends Features<T>> extends ViewportState.Features<T> {
    Relation<IViewport, List<IViewport>, Listener<List<IViewport>>, Features<?>> VIEWPORTS = new RelationBuilder<IViewport, List<IViewport>, Listener<List<IViewport>>, Features<?>>().name("viewports").many(true).mandatory(true).contains(true).id(StaticViewportState.FeatureIDs.VIEWPORTS).concept(() -> GraphicPipelineModelDefinition.Groups.I_VIEWPORT).build();
    Relation<Scissor, List<Scissor>, Listener<List<Scissor>>, Features<?>> SCISSORS = new RelationBuilder<Scissor, List<Scissor>, Listener<List<Scissor>>, Features<?>>().name("scissors").many(true).mandatory(true).contains(true).id(StaticViewportState.FeatureIDs.SCISSORS).concept(() -> GraphicPipelineModelDefinition.Groups.SCISSOR).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(VIEWPORTS, SCISSORS);
  }

  interface Builder extends IFeaturedObject.Builder<StaticViewportState> {
    Builder addViewport(Supplier<IViewport> viewport);
    Builder addScissor(Supplier<Scissor> scissor);
    Builder addViewports(List<IViewport> viewports);
    Builder addScissors(List<Scissor> scissors);
  }
}
