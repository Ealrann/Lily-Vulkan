package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SwapchainConfigurationBuilder;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface SwapchainConfiguration extends LMObject {
  static Builder builder() {
    return new SwapchainConfigurationBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int requiredSwapImageCount();
  List<EImageUsage> swapImageUsages();
  boolean presentWhenVBlank();
  boolean acquireWaitForVBlank();
  boolean allowingAccessFromCompute();
  SwapImageAttachment colorAttachment();
  void requiredSwapImageCount(final int requiredSwapImageCount);
  void presentWhenVBlank(final boolean presentWhenVBlank);
  void acquireWaitForVBlank(final boolean acquireWaitForVBlank);
  void allowingAccessFromCompute(final boolean allowingAccessFromCompute);
  void colorAttachment(final SwapImageAttachment colorAttachment);

  interface FeatureIDs {
    int REQUIRED_SWAP_IMAGE_COUNT = -733899471;
    int SWAP_IMAGE_USAGES = -1830526545;
    int PRESENT_WHENV_BLANK = 578850120;
    int ACQUIRE_WAIT_FORV_BLANK = -166313593;
    int ALLOWING_ACCESS_FROM_COMPUTE = -1789497083;
    int COLOR_ATTACHMENT = -2056708613;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> REQUIRED_SWAP_IMAGE_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("requiredSwapImageCount").defaultValue("3").id(SwapchainConfiguration.FeatureIDs.REQUIRED_SWAP_IMAGE_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<EImageUsage, List<EImageUsage>, Listener<List<EImageUsage>>, Features<?>> SWAP_IMAGE_USAGES = new AttributeBuilder<EImageUsage, List<EImageUsage>, Listener<List<EImageUsage>>, Features<?>>().name("swapImageUsages").many(true).id(SwapchainConfiguration.FeatureIDs.SWAP_IMAGE_USAGES).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_USAGE).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> PRESENT_WHENV_BLANK = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("presentWhenVBlank").mandatory(true).defaultValue("true").id(SwapchainConfiguration.FeatureIDs.PRESENT_WHENV_BLANK).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ACQUIRE_WAIT_FORV_BLANK = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("acquireWaitForVBlank").mandatory(true).defaultValue("true").id(SwapchainConfiguration.FeatureIDs.ACQUIRE_WAIT_FORV_BLANK).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ALLOWING_ACCESS_FROM_COMPUTE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("allowingAccessFromCompute").mandatory(true).defaultValue("false").id(SwapchainConfiguration.FeatureIDs.ALLOWING_ACCESS_FROM_COMPUTE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Relation<SwapImageAttachment, SwapImageAttachment, Listener<SwapImageAttachment>, Features<?>> COLOR_ATTACHMENT = new RelationBuilder<SwapImageAttachment, SwapImageAttachment, Listener<SwapImageAttachment>, Features<?>>().name("colorAttachment").mandatory(true).contains(true).id(SwapchainConfiguration.FeatureIDs.COLOR_ATTACHMENT).concept(() -> GraphicModelDefinition.Groups.SWAP_IMAGE_ATTACHMENT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(REQUIRED_SWAP_IMAGE_COUNT, SWAP_IMAGE_USAGES, PRESENT_WHENV_BLANK, ACQUIRE_WAIT_FORV_BLANK, ALLOWING_ACCESS_FROM_COMPUTE, COLOR_ATTACHMENT);
  }

  interface Builder extends IFeaturedObject.Builder<SwapchainConfiguration> {
    Builder requiredSwapImageCount(int requiredSwapImageCount);
    Builder addSwapImageUsage(EImageUsage swapImageUsage);
    Builder presentWhenVBlank(boolean presentWhenVBlank);
    Builder acquireWaitForVBlank(boolean acquireWaitForVBlank);
    Builder allowingAccessFromCompute(boolean allowingAccessFromCompute);
    Builder colorAttachment(Supplier<SwapImageAttachment> colorAttachment);
    Builder addSwapImageUsages(List<EImageUsage> swapImageUsages);
  }
}
