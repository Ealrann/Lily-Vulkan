/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.lily.vulkan.model.enumeration.EImageUsage;
import org.sheepy.lily.vulkan.model.enumeration.EPresentMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Swapchain Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getPresentationMode <em>Presentation Mode</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getRequiredSwapImageCount <em>Required Swap Image Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getSwapImageUsages <em>Swap Image Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getAtachments <em>Atachments</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration()
 * @model
 * @generated
 */
public interface SwapchainConfiguration extends EObject
{
	/**
	 * Returns the value of the '<em><b>Presentation Mode</b></em>' attribute.
	 * The default value is <code>"MailBox"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EPresentMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation Mode</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EPresentMode
	 * @see #setPresentationMode(EPresentMode)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration_PresentationMode()
	 * @model default="MailBox" unique="false"
	 * @generated
	 */
	EPresentMode getPresentationMode();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getPresentationMode <em>Presentation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation Mode</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EPresentMode
	 * @see #getPresentationMode()
	 * @generated
	 */
	void setPresentationMode(EPresentMode value);

	/**
	 * Returns the value of the '<em><b>Required Swap Image Count</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Swap Image Count</em>' attribute.
	 * @see #setRequiredSwapImageCount(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration_RequiredSwapImageCount()
	 * @model default="3" unique="false"
	 * @generated
	 */
	int getRequiredSwapImageCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getRequiredSwapImageCount <em>Required Swap Image Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Swap Image Count</em>' attribute.
	 * @see #getRequiredSwapImageCount()
	 * @generated
	 */
	void setRequiredSwapImageCount(int value);

	/**
	 * Returns the value of the '<em><b>Swap Image Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.enumeration.EImageUsage}.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EImageUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swap Image Usages</em>' attribute list.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EImageUsage
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration_SwapImageUsages()
	 * @model
	 * @generated
	 */
	EList<EImageUsage> getSwapImageUsages();

	/**
	 * Returns the value of the '<em><b>Atachments</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atachments</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration_Atachments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ISwapAttachment> getAtachments();

} // SwapchainConfiguration
