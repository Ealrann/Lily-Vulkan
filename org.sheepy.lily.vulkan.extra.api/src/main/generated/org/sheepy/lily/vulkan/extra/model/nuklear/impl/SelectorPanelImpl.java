package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearModelDefinition;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;

public final class SelectorPanelImpl extends FeaturedObject<SelectorPanel.Features<?>> implements SelectorPanel {
  private static final int FEATURE_COUNT = 18;
  private final ModelNotifier<SelectorPanel.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private final String name;
  private boolean catchInputs;
  private boolean reportingHover;
  private int buttonSizePx;
  private int selectionR;
  private int selectionG;
  private int selectionB;
  private boolean printLabels;
  private DirectVariableResolver variableResolver;
  private IInputProvider inputProvider;
  private boolean vertical;
  private boolean autoHideLabels;
  private int fadeOutMs;
  private boolean unsettable;
  private boolean detectHoverOnLabels;

  public SelectorPanelImpl(final String name, final boolean catchInputs,
      final boolean reportingHover, final int buttonSizePx, final int selectionR,
      final int selectionG, final int selectionB, final boolean printLabels,
      final DirectVariableResolver variableResolver, final IInputProvider inputProvider,
      final boolean vertical, final boolean autoHideLabels, final int fadeOutMs,
      final boolean unsettable, final boolean detectHoverOnLabels) {
    this.name = name;
    this.catchInputs = catchInputs;
    this.reportingHover = reportingHover;
    this.buttonSizePx = buttonSizePx;
    this.selectionR = selectionR;
    this.selectionG = selectionG;
    this.selectionB = selectionB;
    this.printLabels = printLabels;
    this.variableResolver = variableResolver;
    this.inputProvider = inputProvider;
    this.vertical = vertical;
    this.autoHideLabels = autoHideLabels;
    this.fadeOutMs = fadeOutMs;
    this.unsettable = unsettable;
    this.detectHoverOnLabels = detectHoverOnLabels;
    setContainer(variableResolver, SelectorPanel.FeatureIDs.VARIABLE_RESOLVER);
    setContainer(inputProvider, SelectorPanel.FeatureIDs.INPUT_PROVIDER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SelectorPanel.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Vector2ic position() {
    return position;
  }

  @Override
  public void position(final Vector2ic position) {
    final var oldValue = this.position;
    this.position = position;
    notifier.notify(IPositionElement.FeatureIDs.POSITION, false, false, oldValue, position);
  }

  @Override
  public EVerticalRelative verticalRelative() {
    return verticalRelative;
  }

  @Override
  public void verticalRelative(final EVerticalRelative verticalRelative) {
    final var oldValue = this.verticalRelative;
    this.verticalRelative = verticalRelative;
    notifier.notify(IPositionElement.FeatureIDs.VERTICAL_RELATIVE, false, false, oldValue, verticalRelative);
  }

  @Override
  public EHorizontalRelative horizontalRelative() {
    return horizontalRelative;
  }

  @Override
  public void horizontalRelative(final EHorizontalRelative horizontalRelative) {
    final var oldValue = this.horizontalRelative;
    this.horizontalRelative = horizontalRelative;
    notifier.notify(IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE, false, false, oldValue, horizontalRelative);
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean catchInputs() {
    return catchInputs;
  }

  @Override
  public void catchInputs(final boolean catchInputs) {
    final var oldValue = this.catchInputs;
    this.catchInputs = catchInputs;
    notifier.notifyBoolean(IPanel.FeatureIDs.CATCH_INPUTS, false, false, oldValue, catchInputs);
  }

  @Override
  public boolean reportingHover() {
    return reportingHover;
  }

  @Override
  public void reportingHover(final boolean reportingHover) {
    final var oldValue = this.reportingHover;
    this.reportingHover = reportingHover;
    notifier.notifyBoolean(IPanel.FeatureIDs.REPORTING_HOVER, false, false, oldValue, reportingHover);
  }

  @Override
  public int buttonSizePx() {
    return buttonSizePx;
  }

  @Override
  public void buttonSizePx(final int buttonSizePx) {
    final var oldValue = this.buttonSizePx;
    this.buttonSizePx = buttonSizePx;
    notifier.notifyInt(SelectorPanel.FeatureIDs.BUTTON_SIZE_PX, false, false, oldValue, buttonSizePx);
  }

  @Override
  public int selectionR() {
    return selectionR;
  }

  @Override
  public void selectionR(final int selectionR) {
    final var oldValue = this.selectionR;
    this.selectionR = selectionR;
    notifier.notifyInt(SelectorPanel.FeatureIDs.SELECTIONR, false, false, oldValue, selectionR);
  }

  @Override
  public int selectionG() {
    return selectionG;
  }

  @Override
  public void selectionG(final int selectionG) {
    final var oldValue = this.selectionG;
    this.selectionG = selectionG;
    notifier.notifyInt(SelectorPanel.FeatureIDs.SELECTIONG, false, false, oldValue, selectionG);
  }

  @Override
  public int selectionB() {
    return selectionB;
  }

  @Override
  public void selectionB(final int selectionB) {
    final var oldValue = this.selectionB;
    this.selectionB = selectionB;
    notifier.notifyInt(SelectorPanel.FeatureIDs.SELECTIONB, false, false, oldValue, selectionB);
  }

  @Override
  public boolean printLabels() {
    return printLabels;
  }

  @Override
  public void printLabels(final boolean printLabels) {
    final var oldValue = this.printLabels;
    this.printLabels = printLabels;
    notifier.notifyBoolean(SelectorPanel.FeatureIDs.PRINT_LABELS, false, false, oldValue, printLabels);
  }

  @Override
  public DirectVariableResolver variableResolver() {
    return variableResolver;
  }

  @Override
  public void variableResolver(final DirectVariableResolver variableResolver) {
    final var oldValue = this.variableResolver;
    final var eventType = variableResolver == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.variableResolver = variableResolver;
    setContainer(variableResolver, SelectorPanel.FeatureIDs.VARIABLE_RESOLVER);
    beforeContainmentNotify(eventType, oldValue, variableResolver);
    notifier.notify(SelectorPanel.FeatureIDs.VARIABLE_RESOLVER, true, false, eventType, oldValue, variableResolver);
    afterContainmentNotify(eventType, oldValue, variableResolver);
  }

  @Override
  public IInputProvider inputProvider() {
    return inputProvider;
  }

  @Override
  public void inputProvider(final IInputProvider inputProvider) {
    final var oldValue = this.inputProvider;
    final var eventType = inputProvider == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.inputProvider = inputProvider;
    setContainer(inputProvider, SelectorPanel.FeatureIDs.INPUT_PROVIDER);
    beforeContainmentNotify(eventType, oldValue, inputProvider);
    notifier.notify(SelectorPanel.FeatureIDs.INPUT_PROVIDER, true, false, eventType, oldValue, inputProvider);
    afterContainmentNotify(eventType, oldValue, inputProvider);
  }

  @Override
  public boolean vertical() {
    return vertical;
  }

  @Override
  public void vertical(final boolean vertical) {
    final var oldValue = this.vertical;
    this.vertical = vertical;
    notifier.notifyBoolean(SelectorPanel.FeatureIDs.VERTICAL, false, false, oldValue, vertical);
  }

  @Override
  public boolean autoHideLabels() {
    return autoHideLabels;
  }

  @Override
  public void autoHideLabels(final boolean autoHideLabels) {
    final var oldValue = this.autoHideLabels;
    this.autoHideLabels = autoHideLabels;
    notifier.notifyBoolean(SelectorPanel.FeatureIDs.AUTO_HIDE_LABELS, false, false, oldValue, autoHideLabels);
  }

  @Override
  public int fadeOutMs() {
    return fadeOutMs;
  }

  @Override
  public void fadeOutMs(final int fadeOutMs) {
    final var oldValue = this.fadeOutMs;
    this.fadeOutMs = fadeOutMs;
    notifier.notifyInt(SelectorPanel.FeatureIDs.FADE_OUT_MS, false, false, oldValue, fadeOutMs);
  }

  @Override
  public boolean unsettable() {
    return unsettable;
  }

  @Override
  public void unsettable(final boolean unsettable) {
    final var oldValue = this.unsettable;
    this.unsettable = unsettable;
    notifier.notifyBoolean(SelectorPanel.FeatureIDs.UNSETTABLE, false, false, oldValue, unsettable);
  }

  @Override
  public boolean detectHoverOnLabels() {
    return detectHoverOnLabels;
  }

  @Override
  public void detectHoverOnLabels(final boolean detectHoverOnLabels) {
    final var oldValue = this.detectHoverOnLabels;
    this.detectHoverOnLabels = detectHoverOnLabels;
    notifier.notifyBoolean(SelectorPanel.FeatureIDs.DETECT_HOVER_ON_LABELS, false, false, oldValue, detectHoverOnLabels);
  }

  @Override
  public Group<SelectorPanel> lmGroup() {
    return NuklearModelDefinition.Groups.SELECTOR_PANEL;
  }

  @Override
  protected FeatureSetter<SelectorPanel> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SelectorPanel> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
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
      case SelectorPanel.FeatureIDs.VARIABLE_RESOLVER -> 11;
      case SelectorPanel.FeatureIDs.INPUT_PROVIDER -> 12;
      case SelectorPanel.FeatureIDs.VERTICAL -> 13;
      case SelectorPanel.FeatureIDs.AUTO_HIDE_LABELS -> 14;
      case SelectorPanel.FeatureIDs.FADE_OUT_MS -> 15;
      case SelectorPanel.FeatureIDs.UNSETTABLE -> 16;
      case SelectorPanel.FeatureIDs.DETECT_HOVER_ON_LABELS -> 17;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SelectorPanel> GET_MAP = new FeatureGetter.Builder<SelectorPanel>(FEATURE_COUNT, SelectorPanelImpl::featureIndexStatic).add(SelectorPanel.FeatureIDs.POSITION, SelectorPanel::position).add(SelectorPanel.FeatureIDs.VERTICAL_RELATIVE, SelectorPanel::verticalRelative).add(SelectorPanel.FeatureIDs.HORIZONTAL_RELATIVE, SelectorPanel::horizontalRelative).add(SelectorPanel.FeatureIDs.NAME, SelectorPanel::name).add(SelectorPanel.FeatureIDs.CATCH_INPUTS, SelectorPanel::catchInputs).add(SelectorPanel.FeatureIDs.REPORTING_HOVER, SelectorPanel::reportingHover).add(SelectorPanel.FeatureIDs.BUTTON_SIZE_PX, SelectorPanel::buttonSizePx).add(SelectorPanel.FeatureIDs.SELECTIONR, SelectorPanel::selectionR).add(SelectorPanel.FeatureIDs.SELECTIONG, SelectorPanel::selectionG).add(SelectorPanel.FeatureIDs.SELECTIONB, SelectorPanel::selectionB).add(SelectorPanel.FeatureIDs.PRINT_LABELS, SelectorPanel::printLabels).add(SelectorPanel.FeatureIDs.VARIABLE_RESOLVER, SelectorPanel::variableResolver).add(SelectorPanel.FeatureIDs.INPUT_PROVIDER, SelectorPanel::inputProvider).add(SelectorPanel.FeatureIDs.VERTICAL, SelectorPanel::vertical).add(SelectorPanel.FeatureIDs.AUTO_HIDE_LABELS, SelectorPanel::autoHideLabels).add(SelectorPanel.FeatureIDs.FADE_OUT_MS, SelectorPanel::fadeOutMs).add(SelectorPanel.FeatureIDs.UNSETTABLE, SelectorPanel::unsettable).add(SelectorPanel.FeatureIDs.DETECT_HOVER_ON_LABELS, SelectorPanel::detectHoverOnLabels).build();
    private static final FeatureSetter<SelectorPanel> SET_MAP = new FeatureSetter.Builder<SelectorPanel>(FEATURE_COUNT, SelectorPanelImpl::featureIndexStatic).add(SelectorPanel.FeatureIDs.POSITION, (object, value) -> ((SelectorPanelImpl) object).position((Vector2ic) value)).add(SelectorPanel.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((SelectorPanelImpl) object).verticalRelative((EVerticalRelative) value)).add(SelectorPanel.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((SelectorPanelImpl) object).horizontalRelative((EHorizontalRelative) value)).add(SelectorPanel.FeatureIDs.CATCH_INPUTS, (object, value) -> ((SelectorPanelImpl) object).catchInputs((boolean) value)).add(SelectorPanel.FeatureIDs.REPORTING_HOVER, (object, value) -> ((SelectorPanelImpl) object).reportingHover((boolean) value)).add(SelectorPanel.FeatureIDs.BUTTON_SIZE_PX, (object, value) -> ((SelectorPanelImpl) object).buttonSizePx((int) value)).add(SelectorPanel.FeatureIDs.SELECTIONR, (object, value) -> ((SelectorPanelImpl) object).selectionR((int) value)).add(SelectorPanel.FeatureIDs.SELECTIONG, (object, value) -> ((SelectorPanelImpl) object).selectionG((int) value)).add(SelectorPanel.FeatureIDs.SELECTIONB, (object, value) -> ((SelectorPanelImpl) object).selectionB((int) value)).add(SelectorPanel.FeatureIDs.PRINT_LABELS, (object, value) -> ((SelectorPanelImpl) object).printLabels((boolean) value)).add(SelectorPanel.FeatureIDs.VARIABLE_RESOLVER, (object, value) -> ((SelectorPanelImpl) object).variableResolver((DirectVariableResolver) value)).add(SelectorPanel.FeatureIDs.INPUT_PROVIDER, (object, value) -> ((SelectorPanelImpl) object).inputProvider((IInputProvider) value)).add(SelectorPanel.FeatureIDs.VERTICAL, (object, value) -> ((SelectorPanelImpl) object).vertical((boolean) value)).add(SelectorPanel.FeatureIDs.AUTO_HIDE_LABELS, (object, value) -> ((SelectorPanelImpl) object).autoHideLabels((boolean) value)).add(SelectorPanel.FeatureIDs.FADE_OUT_MS, (object, value) -> ((SelectorPanelImpl) object).fadeOutMs((int) value)).add(SelectorPanel.FeatureIDs.UNSETTABLE, (object, value) -> ((SelectorPanelImpl) object).unsettable((boolean) value)).add(SelectorPanel.FeatureIDs.DETECT_HOVER_ON_LABELS, (object, value) -> ((SelectorPanelImpl) object).detectHoverOnLabels((boolean) value)).build();
  }
}
