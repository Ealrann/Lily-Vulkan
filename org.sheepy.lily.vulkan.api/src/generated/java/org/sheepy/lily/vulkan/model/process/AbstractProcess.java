/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isWaitingFenceDuringAcquire <em>Waiting Fence During Acquire</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorSetPkg <em>Descriptor Set Pkg</em>}</li>
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
	 * Returns the value of the '<em><b>Waiting Fence During Acquire</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting Fence During Acquire</em>' attribute.
	 * @see #setWaitingFenceDuringAcquire(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_WaitingFenceDuringAcquire()
	 * @model default="false" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='If fenceEnabled, will wait during acquire. Useless for a render process that already wait for image acquiring'"
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
	 * Returns the value of the '<em><b>Descriptor Set Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Set Pkg</em>' containment reference.
	 * @see #setDescriptorSetPkg(DescriptorSetPkg)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_DescriptorSetPkg()
	 * @model containment="true"
	 * @generated
	 */
	DescriptorSetPkg getDescriptorSetPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorSetPkg <em>Descriptor Set Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Set Pkg</em>' containment reference.
	 * @see #getDescriptorSetPkg()
	 * @generated
	 */
	void setDescriptorSetPkg(DescriptorSetPkg value);

	/**
	 * Returns the value of the '<em><b>Pipeline Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait For</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_WaitFor()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Semaphores'"
	 * @generated
	 */
	EList<Semaphore> getWaitFor();

} // AbstractProcess
