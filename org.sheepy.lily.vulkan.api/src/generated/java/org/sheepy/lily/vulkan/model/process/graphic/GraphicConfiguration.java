/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.process.ProcessConfiguration;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getSwapchainConfiguration <em>Swapchain Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getFramebufferConfiguration <em>Framebuffer Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getAcquireWaitStage <em>Acquire Wait Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getSurface <em>Surface</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getRenderPass <em>Render Pass</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getImageViews <em>Image Views</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration()
 * @model
 * @generated
 */
public interface GraphicConfiguration extends ProcessConfiguration
{
	/**
	 * Returns the value of the '<em><b>Swapchain Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swapchain Configuration</em>' containment reference.
	 * @see #setSwapchainConfiguration(SwapchainConfiguration)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_SwapchainConfiguration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SwapchainConfiguration getSwapchainConfiguration();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getSwapchainConfiguration <em>Swapchain Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Swapchain Configuration</em>' containment reference.
	 * @see #getSwapchainConfiguration()
	 * @generated
	 */
	void setSwapchainConfiguration(SwapchainConfiguration value);

	/**
	 * Returns the value of the '<em><b>Framebuffer Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Framebuffer Configuration</em>' containment reference.
	 * @see #setFramebufferConfiguration(FramebufferConfiguration)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_FramebufferConfiguration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FramebufferConfiguration getFramebufferConfiguration();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getFramebufferConfiguration <em>Framebuffer Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Framebuffer Configuration</em>' containment reference.
	 * @see #getFramebufferConfiguration()
	 * @generated
	 */
	void setFramebufferConfiguration(FramebufferConfiguration value);

	/**
	 * Returns the value of the '<em><b>Acquire Wait Stage</b></em>' attribute.
	 * The default value is <code>"COLOR_ATTACHMENT_OUTPUT_BIT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acquire Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setAcquireWaitStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_AcquireWaitStage()
	 * @model default="COLOR_ATTACHMENT_OUTPUT_BIT" unique="false"
	 * @generated
	 */
	EPipelineStage getAcquireWaitStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getAcquireWaitStage <em>Acquire Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acquire Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getAcquireWaitStage()
	 * @generated
	 */
	void setAcquireWaitStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Surface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surface</em>' containment reference.
	 * @see #setSurface(PhysicalSurface)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_Surface()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PhysicalSurface getSurface();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getSurface <em>Surface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surface</em>' containment reference.
	 * @see #getSurface()
	 * @generated
	 */
	void setSurface(PhysicalSurface value);

	/**
	 * Returns the value of the '<em><b>Render Pass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Render Pass</em>' containment reference.
	 * @see #setRenderPass(RenderPass)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_RenderPass()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RenderPass getRenderPass();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getRenderPass <em>Render Pass</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Pass</em>' containment reference.
	 * @see #getRenderPass()
	 * @generated
	 */
	void setRenderPass(RenderPass value);

	/**
	 * Returns the value of the '<em><b>Image Views</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Views</em>' containment reference.
	 * @see #setImageViews(ImageViews)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_ImageViews()
	 * @model containment="true"
	 * @generated
	 */
	ImageViews getImageViews();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getImageViews <em>Image Views</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Views</em>' containment reference.
	 * @see #getImageViews()
	 * @generated
	 */
	void setImageViews(ImageViews value);

} // GraphicConfiguration
