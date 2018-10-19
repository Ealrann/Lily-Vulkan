/**
 */
package org.sheepy.vulkan.model.process;

import org.sheepy.vulkan.model.enumeration.ECullMode;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EPresentMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graphic Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.GraphicConfiguration#isClearBeforeRender <em>Clear Before Render</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getPresentationMode <em>Presentation Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getSwapImageUsage <em>Swap Image Usage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getFrameWaitStage <em>Frame Wait Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getColorDomain <em>Color Domain</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getRasterizerCullMode <em>Rasterizer Cull Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getRasterizerFrontFace <em>Rasterizer Front Face</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicConfiguration()
 * @model
 * @generated
 */
public interface GraphicConfiguration extends Configuration
{
	/**
	 * Returns the value of the '<em><b>Clear Before Render</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clear Before Render</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Before Render</em>' attribute.
	 * @see #setClearBeforeRender(boolean)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicConfiguration_ClearBeforeRender()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isClearBeforeRender();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#isClearBeforeRender <em>Clear Before Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Before Render</em>' attribute.
	 * @see #isClearBeforeRender()
	 * @generated
	 */
	void setClearBeforeRender(boolean value);

	/**
	 * Returns the value of the '<em><b>Presentation Mode</b></em>' attribute.
	 * The default value is <code>"MailBox"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPresentMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Presentation Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPresentMode
	 * @see #setPresentationMode(EPresentMode)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicConfiguration_PresentationMode()
	 * @model default="MailBox" unique="false"
	 * @generated
	 */
	EPresentMode getPresentationMode();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getPresentationMode <em>Presentation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPresentMode
	 * @see #getPresentationMode()
	 * @generated
	 */
	void setPresentationMode(EPresentMode value);

	/**
	 * Returns the value of the '<em><b>Swap Image Usage</b></em>' attribute.
	 * The default value is <code>"16"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Swap Image Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swap Image Usage</em>' attribute.
	 * @see #setSwapImageUsage(int)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicConfiguration_SwapImageUsage()
	 * @model default="16" unique="false"
	 * @generated
	 */
	int getSwapImageUsage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getSwapImageUsage <em>Swap Image Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Swap Image Usage</em>' attribute.
	 * @see #getSwapImageUsage()
	 * @generated
	 */
	void setSwapImageUsage(int value);

	/**
	 * Returns the value of the '<em><b>Frame Wait Stage</b></em>' attribute.
	 * The default value is <code>"COLOR_ATTACHMENT_OUTPUT_BIT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame Wait Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setFrameWaitStage(EPipelineStage)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicConfiguration_FrameWaitStage()
	 * @model default="COLOR_ATTACHMENT_OUTPUT_BIT" unique="false"
	 * @generated
	 */
	EPipelineStage getFrameWaitStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getFrameWaitStage <em>Frame Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frame Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getFrameWaitStage()
	 * @generated
	 */
	void setFrameWaitStage(EPipelineStage value);

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
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicConfiguration_ColorDomain()
	 * @model containment="true"
	 * @generated
	 */
	ColorDomain getColorDomain();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getColorDomain <em>Color Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Domain</em>' containment reference.
	 * @see #getColorDomain()
	 * @generated
	 */
	void setColorDomain(ColorDomain value);

	/**
	 * Returns the value of the '<em><b>Rasterizer Cull Mode</b></em>' attribute.
	 * The default value is <code>"BACK_BIT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ECullMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rasterizer Cull Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rasterizer Cull Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECullMode
	 * @see #setRasterizerCullMode(ECullMode)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicConfiguration_RasterizerCullMode()
	 * @model default="BACK_BIT" unique="false"
	 * @generated
	 */
	ECullMode getRasterizerCullMode();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getRasterizerCullMode <em>Rasterizer Cull Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rasterizer Cull Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECullMode
	 * @see #getRasterizerCullMode()
	 * @generated
	 */
	void setRasterizerCullMode(ECullMode value);

	/**
	 * Returns the value of the '<em><b>Rasterizer Front Face</b></em>' attribute.
	 * The default value is <code>"CLOCKWISE"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EFrontFace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rasterizer Front Face</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rasterizer Front Face</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFrontFace
	 * @see #setRasterizerFrontFace(EFrontFace)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicConfiguration_RasterizerFrontFace()
	 * @model default="CLOCKWISE" unique="false"
	 * @generated
	 */
	EFrontFace getRasterizerFrontFace();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getRasterizerFrontFace <em>Rasterizer Front Face</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rasterizer Front Face</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFrontFace
	 * @see #getRasterizerFrontFace()
	 * @generated
	 */
	void setRasterizerFrontFace(EFrontFace value);

} // GraphicConfiguration
