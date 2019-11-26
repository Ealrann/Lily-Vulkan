/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Semaphore</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Semaphore#isSignalizedAtInit <em>Signalized At Init</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Semaphore#getWaitStage <em>Wait Stage</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getSemaphore()
 * @model
 * @generated
 */
public interface Semaphore extends LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Signalized At Init</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signalized At Init</em>' attribute.
	 * @see #setSignalizedAtInit(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getSemaphore_SignalizedAtInit()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isSignalizedAtInit();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Semaphore#isSignalizedAtInit <em>Signalized At Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signalized At Init</em>' attribute.
	 * @see #isSignalizedAtInit()
	 * @generated
	 */
	void setSignalizedAtInit(boolean value);

	/**
	 * Returns the value of the '<em><b>Wait Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setWaitStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getSemaphore_WaitStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getWaitStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Semaphore#getWaitStage <em>Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getWaitStage()
	 * @generated
	 */
	void setWaitStage(EPipelineStage value);

} // Semaphore
