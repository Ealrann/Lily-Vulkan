/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Swapchain Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getRequiredSwapImageCount <em>Required Swap Image Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getSwapImageUsages <em>Swap Image Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#isPresentWhenVBlank <em>Present When VBlank</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#isAcquireWaitForVBlank <em>Acquire Wait For VBlank</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#isAllowingAccessFromCompute <em>Allowing Access From Compute</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getColorAttachment <em>Color Attachment</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface SwapchainConfiguration extends ILilyEObject
{
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
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EImageUsage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swap Image Usages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EImageUsage
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration_SwapImageUsages()
	 * @model
	 * @generated
	 */
	EList<EImageUsage> getSwapImageUsages();

	/**
	 * Returns the value of the '<em><b>Present When VBlank</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Present When VBlank</em>' attribute.
	 * @see #setPresentWhenVBlank(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration_PresentWhenVBlank()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isPresentWhenVBlank();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#isPresentWhenVBlank <em>Present When VBlank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Present When VBlank</em>' attribute.
	 * @see #isPresentWhenVBlank()
	 * @generated
	 */
	void setPresentWhenVBlank(boolean value);

	/**
	 * Returns the value of the '<em><b>Acquire Wait For VBlank</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acquire Wait For VBlank</em>' attribute.
	 * @see #setAcquireWaitForVBlank(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration_AcquireWaitForVBlank()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isAcquireWaitForVBlank();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#isAcquireWaitForVBlank <em>Acquire Wait For VBlank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acquire Wait For VBlank</em>' attribute.
	 * @see #isAcquireWaitForVBlank()
	 * @generated
	 */
	void setAcquireWaitForVBlank(boolean value);

	/**
	 * Returns the value of the '<em><b>Allowing Access From Compute</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allowing Access From Compute</em>' attribute.
	 * @see #setAllowingAccessFromCompute(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration_AllowingAccessFromCompute()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAllowingAccessFromCompute();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#isAllowingAccessFromCompute <em>Allowing Access From Compute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allowing Access From Compute</em>' attribute.
	 * @see #isAllowingAccessFromCompute()
	 * @generated
	 */
	void setAllowingAccessFromCompute(boolean value);

	/**
	 * Returns the value of the '<em><b>Color Attachment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Attachment</em>' containment reference.
	 * @see #setColorAttachment(SwapImageAttachment)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapchainConfiguration_ColorAttachment()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SwapImageAttachment getColorAttachment();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getColorAttachment <em>Color Attachment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Attachment</em>' containment reference.
	 * @see #getColorAttachment()
	 * @generated
	 */
	void setColorAttachment(SwapImageAttachment value);

} // SwapchainConfiguration
