/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.ResourceContainer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getResourceContainer <em>Resource Container</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorSets <em>Descriptor Sets</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getUnits <em>Units</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getSemaphores <em>Semaphores</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isResetAllowed <em>Reset Allowed</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isInitializedSignalizedSemaphore <em>Initialized Signalized Semaphore</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDependentProcesses <em>Dependent Processes</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess()
 * @model abstract="true"
 * @generated
 */
public interface AbstractProcess extends IProcess
{
	/**
	 * Returns the value of the '<em><b>Resource Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Container</em>' containment reference.
	 * @see #setResourceContainer(ResourceContainer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_ResourceContainer()
	 * @model containment="true"
	 * @generated
	 */
	ResourceContainer getResourceContainer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getResourceContainer <em>Resource Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Container</em>' containment reference.
	 * @see #getResourceContainer()
	 * @generated
	 */
	void setResourceContainer(ResourceContainer value);

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
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.IProcessUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_Units()
	 * @model containment="true"
	 * @generated
	 */
	EList<IProcessUnit> getUnits();

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
	 * Returns the value of the '<em><b>Initialized Signalized Semaphore</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized Signalized Semaphore</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Signalized Semaphore</em>' attribute.
	 * @see #setInitializedSignalizedSemaphore(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_InitializedSignalizedSemaphore()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isInitializedSignalizedSemaphore();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isInitializedSignalizedSemaphore <em>Initialized Signalized Semaphore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Signalized Semaphore</em>' attribute.
	 * @see #isInitializedSignalizedSemaphore()
	 * @generated
	 */
	void setInitializedSignalizedSemaphore(boolean value);

	/**
	 * Returns the value of the '<em><b>Dependent Processes</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.ProcessSemaphore}.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.model.process.ProcessSemaphore#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependent Processes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependent Processes</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_DependentProcesses()
	 * @see org.sheepy.lily.vulkan.model.process.ProcessSemaphore#getProcess
	 * @model opposite="process"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel property='Readonly'"
	 * @generated
	 */
	EList<ProcessSemaphore> getDependentProcesses();

	/**
	 * Returns the value of the '<em><b>Semaphores</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.ProcessSemaphore}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semaphores</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semaphores</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractProcess_Semaphores()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProcessSemaphore> getSemaphores();

} // AbstractProcess
