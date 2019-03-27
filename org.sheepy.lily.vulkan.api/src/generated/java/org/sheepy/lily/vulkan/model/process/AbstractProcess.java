/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.Semaphore;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isFenceEnabled <em>Fence Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isWaitingFenceDuringAcquire <em>Waiting Fence During Acquire</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorSets <em>Descriptor Sets</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isResetAllowed <em>Reset Allowed</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getSignals <em>Signals</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getWaitFor <em>Wait For</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess()
 * @model abstract="true"
 * @generated
 */
public interface AbstractProcess extends IProcess
{
	/**
	 * Returns the value of the '<em><b>Fence Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fence Enabled</em>' attribute.
	 * @see #setFenceEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_FenceEnabled()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isFenceEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isFenceEnabled <em>Fence Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fence Enabled</em>' attribute.
	 * @see #isFenceEnabled()
	 * @generated
	 */
	void setFenceEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Waiting Fence During Acquire</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting Fence During Acquire</em>' attribute.
	 * @see #setWaitingFenceDuringAcquire(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_WaitingFenceDuringAcquire()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isWaitingFenceDuringAcquire();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isWaitingFenceDuringAcquire <em>Waiting Fence During Acquire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Waiting Fence During Acquire</em>' attribute.
	 * @see #isWaitingFenceDuringAcquire()
	 * @generated
	 */
	void setWaitingFenceDuringAcquire(boolean value);

	/**
	 * Returns the value of the '<em><b>Descriptor Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.DescriptorSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Sets</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_DescriptorSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<DescriptorSet> getDescriptorSets();

	/**
	 * Returns the value of the '<em><b>Pipeline Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipeline Pkg</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #setPipelinePkg(PipelinePkg)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_PipelinePkg()
	 * @model containment="true"
	 * @generated
	 */
	PipelinePkg getPipelinePkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getPipelinePkg <em>Pipeline Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #getPipelinePkg()
	 * @generated
	 */
	void setPipelinePkg(PipelinePkg value);

	/**
	 * Returns the value of the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reset Allowed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset Allowed</em>' attribute.
	 * @see #setResetAllowed(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_ResetAllowed()
	 * @model unique="false"
	 * @generated
	 */
	boolean isResetAllowed();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isResetAllowed <em>Reset Allowed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset Allowed</em>' attribute.
	 * @see #isResetAllowed()
	 * @generated
	 */
	void setResetAllowed(boolean value);

	/**
	 * Returns the value of the '<em><b>Signals</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.Semaphore}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signals</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_Signals()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Semaphores'"
	 * @generated
	 */
	EList<Semaphore> getSignals();

	/**
	 * Returns the value of the '<em><b>Wait For</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.Semaphore}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait For</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait For</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_WaitFor()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Semaphores'"
	 * @generated
	 */
	EList<Semaphore> getWaitFor();

} // AbstractProcess
