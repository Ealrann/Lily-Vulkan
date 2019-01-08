/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.vulkan.model.ColorDomain;

import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EPresentMode;

import org.sheepy.vulkan.model.process.Configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#isClearBeforeRender <em>Clear Before Render</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getPresentationMode <em>Presentation Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getSwapImageUsages <em>Swap Image Usages</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getAcquireWaitStage <em>Acquire Wait Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getColorDomain <em>Color Domain</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration()
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
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_ClearBeforeRender()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isClearBeforeRender();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#isClearBeforeRender <em>Clear Before Render</em>}' attribute.
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
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_PresentationMode()
	 * @model default="MailBox" unique="false"
	 * @generated
	 */
	EPresentMode getPresentationMode();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getPresentationMode <em>Presentation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPresentMode
	 * @see #getPresentationMode()
	 * @generated
	 */
	void setPresentationMode(EPresentMode value);

	/**
	 * Returns the value of the '<em><b>Swap Image Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EImageUsage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Swap Image Usages</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swap Image Usages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EImageUsage
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_SwapImageUsages()
	 * @model unique="false"
	 * @generated
	 */
	EList<EImageUsage> getSwapImageUsages();

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
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_AcquireWaitStage()
	 * @model default="COLOR_ATTACHMENT_OUTPUT_BIT" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='The stage on which we should wait until acquire the next image'"
	 * @generated
	 */
	EPipelineStage getAcquireWaitStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getAcquireWaitStage <em>Acquire Wait Stage</em>}' attribute.
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
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicConfiguration_ColorDomain()
	 * @model containment="true"
	 * @generated
	 */
	ColorDomain getColorDomain();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getColorDomain <em>Color Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Domain</em>' containment reference.
	 * @see #getColorDomain()
	 * @generated
	 */
	void setColorDomain(ColorDomain value);

} // GraphicConfiguration
