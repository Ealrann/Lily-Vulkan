package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntitySelection;
import org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy;
import org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.SelectionProxyImpl;

public final class SelectionProxyBuilder implements Builder {
  private EMousePickMode pickMode = EMousePickMode.Enabled;
  private Supplier<IEntitySelection> selection = () -> null;
  private Supplier<IEntitySelection> focus = () -> null;

  public SelectionProxyBuilder() {
  }

  @Override
  public SelectionProxyBuilder pickMode(EMousePickMode pickMode) {
    this.pickMode = pickMode;
    return this;
  }

  @Override
  public SelectionProxyBuilder selection(Supplier<IEntitySelection> selection) {
    this.selection = selection;
    return this;
  }

  @Override
  public SelectionProxyBuilder focus(Supplier<IEntitySelection> focus) {
    this.focus = focus;
    return this;
  }

  @Override
  public SelectionProxy build() {
    final var built = new SelectionProxyImpl(pickMode);
    built.selection(selection.get());
    built.focus(focus.get());
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
    private static final FeatureInserter<SelectionProxyBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SelectionProxyBuilder>(1, Inserters::attributeIndex).add(SelectionProxy.FeatureIDs.PICK_MODE, (builder, value) -> builder.pickMode((EMousePickMode) value)).build();
    private static final RelationLazyInserter<SelectionProxyBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SelectionProxyBuilder>(2, Inserters::relationIndex).add(SelectionProxy.FeatureIDs.SELECTION, (builder, value) -> builder.selection((Supplier<IEntitySelection>) value)).add(SelectionProxy.FeatureIDs.FOCUS, (builder, value) -> builder.focus((Supplier<IEntitySelection>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SelectionProxy.FeatureIDs.PICK_MODE -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case SelectionProxy.FeatureIDs.SELECTION -> 0;
        case SelectionProxy.FeatureIDs.FOCUS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
