/**
 */
package org.sheepy.vulkan.model.process;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Composite Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.AbstractCompositePipeline#getPipelines <em>Pipelines</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractCompositePipeline()
 * @model abstract="true"
 * @generated
 */
public interface AbstractCompositePipeline extends AbstractPipeline
{
	/**
	 * Returns the value of the '<em><b>Pipelines</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.process.AbstractPipeline}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipelines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipelines</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractCompositePipeline_Pipelines()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractPipeline> getPipelines();

} // AbstractCompositePipeline
