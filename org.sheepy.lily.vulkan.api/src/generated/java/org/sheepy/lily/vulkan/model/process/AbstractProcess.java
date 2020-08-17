/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorPool <em>Descriptor Pool</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isWaitingFenceDuringAcquire <em>Waiting Fence During Acquire</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isResetAllowed <em>Reset Allowed</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getExtensionPkg <em>Extension Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getExecutionManager <em>Execution Manager</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess()
 * @model abstract="true"
 * @generated
 */
public interface AbstractProcess extends IProcess
{
	/**
	 * Returns the value of the '<em><b>Descriptor Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Pool</em>' containment reference.
	 * @see #setDescriptorPool(DescriptorPool)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_DescriptorPool()
	 * @model containment="true"
	 * @generated
	 */
	DescriptorPool getDescriptorPool();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorPool <em>Descriptor Pool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Pool</em>' containment reference.
	 * @see #getDescriptorPool()
	 * @generated
	 */
	void setDescriptorPool(DescriptorPool value);

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
	 * Returns the value of the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #setExtensionPkg(ProcessExtensionPkg)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_ExtensionPkg()
	 * @model containment="true"
	 * @generated
	 */
	ProcessExtensionPkg getExtensionPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getExtensionPkg <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #getExtensionPkg()
	 * @generated
	 */
	void setExtensionPkg(ProcessExtensionPkg value);

	/**
	 * Returns the value of the '<em><b>Execution Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Manager</em>' containment reference.
	 * @see #setExecutionManager(ProcessExecutionManager)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_ExecutionManager()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ProcessExecutionManager getExecutionManager();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getExecutionManager <em>Execution Manager</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Manager</em>' containment reference.
	 * @see #getExecutionManager()
	 * @generated
	 */
	void setExecutionManager(ProcessExecutionManager value);

} // AbstractProcess
