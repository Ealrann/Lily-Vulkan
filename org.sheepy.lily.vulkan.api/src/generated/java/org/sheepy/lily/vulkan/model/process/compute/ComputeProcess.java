/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getSourceEngine <em>Source Engine</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeProcess()
 * @model
 * @generated
 */
public interface ComputeProcess extends AbstractProcess
{

	/**
	 * Returns the value of the '<em><b>Pipeline Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #setPipelinePkg(PipelinePkg)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeProcess_PipelinePkg()
	 * @model containment="true"
	 * @generated
	 */
	PipelinePkg getPipelinePkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getPipelinePkg <em>Pipeline Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #getPipelinePkg()
	 * @generated
	 */
	void setPipelinePkg(PipelinePkg value);

	/**
	 * Returns the value of the '<em><b>Source Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Engine</em>' reference.
	 * @see #setSourceEngine(IEngine)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeProcess_SourceEngine()
	 * @model
	 * @generated
	 */
	IEngine getSourceEngine();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getSourceEngine <em>Source Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Engine</em>' reference.
	 * @see #getSourceEngine()
	 * @generated
	 */
	void setSourceEngine(IEngine value);

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(ComputeConfiguration)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputeProcess_Configuration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ComputeConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(ComputeConfiguration value);} // ComputeProcess
