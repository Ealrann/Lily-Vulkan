/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.process.Configuration;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getColorDomain <em>Color Domain</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration()
 * @model
 * @generated
 */
public interface GraphicConfiguration extends Configuration
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
	 * <p>
	 * If the meaning of the '<em>Acquire Wait Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * Returns the value of the '<em><b>Color Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Domain</em>' containment reference.
	 * @see #setColorDomain(ColorDomain)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_ColorDomain()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ColorDomain getColorDomain();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getColorDomain <em>Color Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Domain</em>' containment reference.
	 * @see #getColorDomain()
	 * @generated
	 */
	void setColorDomain(ColorDomain value);

} // GraphicConfiguration
