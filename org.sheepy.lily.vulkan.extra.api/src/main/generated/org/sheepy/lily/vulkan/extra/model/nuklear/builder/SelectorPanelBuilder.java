package org.sheepy.lily.vulkan.extra.model.nuklear.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel.Builder;
import org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl;

public final class SelectorPanelBuilder implements Builder {
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private String name;
  private boolean catchInputs = true;
  private boolean reportingHover = true;
  private int buttonSizePx = 32;
  private int selectionR = 0;
  private int selectionG = 135;
  private int selectionB = 255;
  private boolean printLabels;
  private Supplier<DirectVariableResolver> variableResolver;
  private Supplier<IInputProvider> inputProvider;
  private boolean vertical = true;
  private boolean autoHideLabels = true;
  private int fadeOutMs = 500;
  private boolean unsettable = false;
  private boolean detectHoverOnLabels = false;

  public SelectorPanelBuilder() {
  }

  @Override
  public SelectorPanelBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public SelectorPanelBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public SelectorPanelBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public SelectorPanelBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SelectorPanelBuilder catchInputs(boolean catchInputs) {
    this.catchInputs = catchInputs;
    return this;
  }

  @Override
  public SelectorPanelBuilder reportingHover(boolean reportingHover) {
    this.reportingHover = reportingHover;
    return this;
  }

  @Override
  public SelectorPanelBuilder buttonSizePx(int buttonSizePx) {
    this.buttonSizePx = buttonSizePx;
    return this;
  }

  @Override
  public SelectorPanelBuilder selectionR(int selectionR) {
    this.selectionR = selectionR;
    return this;
  }

  @Override
  public SelectorPanelBuilder selectionG(int selectionG) {
    this.selectionG = selectionG;
    return this;
  }

  @Override
  public SelectorPanelBuilder selectionB(int selectionB) {
    this.selectionB = selectionB;
    return this;
  }

  @Override
  public SelectorPanelBuilder printLabels(boolean printLabels) {
    this.printLabels = printLabels;
    return this;
  }

  @Override
  public SelectorPanelBuilder variableResolver(Supplier<DirectVariableResolver> variableResolver) {
    this.variableResolver = variableResolver;
    return this;
  }

  @Override
  public SelectorPanelBuilder inputProvider(Supplier<IInputProvider> inputProvider) {
    this.inputProvider = inputProvider;
    return this;
  }

  @Override
  public SelectorPanelBuilder vertical(boolean vertical) {
    this.vertical = vertical;
    return this;
  }

  @Override
  public SelectorPanelBuilder autoHideLabels(boolean autoHideLabels) {
    this.autoHideLabels = autoHideLabels;
    return this;
  }

  @Override
  public SelectorPanelBuilder fadeOutMs(int fadeOutMs) {
    this.fadeOutMs = fadeOutMs;
    return this;
  }

  @Override
  public SelectorPanelBuilder unsettable(boolean unsettable) {
    this.unsettable = unsettable;
    return this;
  }

  @Override
  public SelectorPanelBuilder detectHoverOnLabels(boolean detectHoverOnLabels) {
    this.detectHoverOnLabels = detectHoverOnLabels;
    return this;
  }

  @Override
  public SelectorPanel build() {
    final var built = new SelectorPanelImpl(name, catchInputs, reportingHover, buttonSizePx, selectionR, selectionG, selectionB, printLabels, variableResolver.get(), inputProvider.get(), vertical, autoHideLabels, fadeOutMs, unsettable, detectHoverOnLabels);
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
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
    private static final FeatureInserter<SelectorPanelBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SelectorPanelBuilder>(16, Inserters::attributeIndex).add(SelectorPanel.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(SelectorPanel.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(SelectorPanel.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(SelectorPanel.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(SelectorPanel.FeatureIDs.CATCH_INPUTS, (builder, value) -> builder.catchInputs((boolean) value)).add(SelectorPanel.FeatureIDs.REPORTING_HOVER, (builder, value) -> builder.reportingHover((boolean) value)).add(SelectorPanel.FeatureIDs.BUTTON_SIZE_PX, (builder, value) -> builder.buttonSizePx((int) value)).add(SelectorPanel.FeatureIDs.SELECTIONR, (builder, value) -> builder.selectionR((int) value)).add(SelectorPanel.FeatureIDs.SELECTIONG, (builder, value) -> builder.selectionG((int) value)).add(SelectorPanel.FeatureIDs.SELECTIONB, (builder, value) -> builder.selectionB((int) value)).add(SelectorPanel.FeatureIDs.PRINT_LABELS, (builder, value) -> builder.printLabels((boolean) value)).add(SelectorPanel.FeatureIDs.VERTICAL, (builder, value) -> builder.vertical((boolean) value)).add(SelectorPanel.FeatureIDs.AUTO_HIDE_LABELS, (builder, value) -> builder.autoHideLabels((boolean) value)).add(SelectorPanel.FeatureIDs.FADE_OUT_MS, (builder, value) -> builder.fadeOutMs((int) value)).add(SelectorPanel.FeatureIDs.UNSETTABLE, (builder, value) -> builder.unsettable((boolean) value)).add(SelectorPanel.FeatureIDs.DETECT_HOVER_ON_LABELS, (builder, value) -> builder.detectHoverOnLabels((boolean) value)).build();
    private static final RelationLazyInserter<SelectorPanelBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SelectorPanelBuilder>(2, Inserters::relationIndex).add(SelectorPanel.FeatureIDs.VARIABLE_RESOLVER, (builder, value) -> builder.variableResolver((Supplier<DirectVariableResolver>) value)).add(SelectorPanel.FeatureIDs.INPUT_PROVIDER, (builder, value) -> builder.inputProvider((Supplier<IInputProvider>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SelectorPanel.FeatureIDs.POSITION -> 0;
        case SelectorPanel.FeatureIDs.VERTICAL_RELATIVE -> 1;
        case SelectorPanel.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
        case SelectorPanel.FeatureIDs.NAME -> 3;
        case SelectorPanel.FeatureIDs.CATCH_INPUTS -> 4;
        case SelectorPanel.FeatureIDs.REPORTING_HOVER -> 5;
        case SelectorPanel.FeatureIDs.BUTTON_SIZE_PX -> 6;
        case SelectorPanel.FeatureIDs.SELECTIONR -> 7;
        case SelectorPanel.FeatureIDs.SELECTIONG -> 8;
        case SelectorPanel.FeatureIDs.SELECTIONB -> 9;
        case SelectorPanel.FeatureIDs.PRINT_LABELS -> 10;
        case SelectorPanel.FeatureIDs.VERTICAL -> 11;
        case SelectorPanel.FeatureIDs.AUTO_HIDE_LABELS -> 12;
        case SelectorPanel.FeatureIDs.FADE_OUT_MS -> 13;
        case SelectorPanel.FeatureIDs.UNSETTABLE -> 14;
        case SelectorPanel.FeatureIDs.DETECT_HOVER_ON_LABELS -> 15;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case SelectorPanel.FeatureIDs.VARIABLE_RESOLVER -> 0;
        case SelectorPanel.FeatureIDs.INPUT_PROVIDER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
